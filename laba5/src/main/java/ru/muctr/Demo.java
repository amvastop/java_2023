package ru.muctr;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.*;


public class Demo {
    public static void main(String[] args) throws IOException {
        ArrayList<Patent> arrayListPatents = readFile(); //2.	Прочитайте информацию из файла “patents.csv”, сохраните её в список типа List<Patent>. Поля в файле разделены “,” (3 символа). Файл может содержать дубликаты.
        LinkedList<Patent> listModelingPatents = createModelingList(arrayListPatents); // 3.	Создайте коллекцию патентов по теме «Моделирование» (modeling).
        Patent max = findeMaxMpkPatent(arrayListPatents);// 4.	Найдите патент, для которого указано наибольшее количество рубрик МПК.
        ArrayList<Patent> listNoChaiPatents = createNoChaiList(arrayListPatents); //5.	Создайте сортированную по дате регистрации коллекцию патентов не из Китая.
        ArrayList<Patent> listNoChaiPatentsCopy = new ArrayList<>(listNoChaiPatents);
        Comparator<Patent> byDate = Comparator.comparing(Patent::getDate);
        sortListByDateTypeA(listNoChaiPatents,byDate);
        TreeSet<Patent> setNoChaiPatents = sortListByDateTypeB(listNoChaiPatentsCopy, byDate);
        ArrayList<String> listPatentMpkGtOne =  createListPatentMpkGtOne(arrayListPatents);//6.	Создайте коллекцию рубрик МПК, указанных в файле более одного раза (используя Map, List)

        JSONArray modelingPatents = new JSONArray(listModelingPatents);
        JSONArray sortedListNoChaiPatents = new JSONArray(listNoChaiPatents);
        JSONArray sortedSetNoChaiPatents = new JSONArray(setNoChaiPatents);
        JSONArray patentMpkGtOne = new JSONArray(listPatentMpkGtOne);
        JSONObject jo = new JSONObject();
        jo.append("max", max);
        jo.append("modelingPatents", modelingPatents);
        jo.append("sortedListNoChaiPatents", sortedListNoChaiPatents);
        jo.append("sortedSetNoChaiPatents", sortedSetNoChaiPatents);
        jo.append("patentMpkGtOne", patentMpkGtOne);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/ans.json"))) {
            bw.write(jo.toString(3));

        }

    }
    public static ArrayList<Patent> readFile() throws IOException {
        LinkedList<Patent> linkedListPatents = new LinkedList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("src/patents.csv")))
        {
            String lineString;
            while ((lineString = br.readLine()) != null)
            {
                String[] splitArray = lineString.split("\",\"");
                linkedListPatents.addLast(new Patent(splitArray));
            }

        }
        return new ArrayList<>(linkedListPatents);

    }
    public static LinkedList<Patent> createModelingList(ArrayList<Patent> arrayListPatents)
    {
        LinkedList<Patent> listModelingPatents = new LinkedList<>();
        for (Patent patent: arrayListPatents)
        {
            if (patent.getTitle().contains("modeling"))
                listModelingPatents.add(patent);
        }
        return listModelingPatents;

    }
    public static Patent findeMaxMpkPatent(ArrayList<Patent> arrayListPatents)
    {
        Patent max = arrayListPatents.get(0);
        for(Patent patent: arrayListPatents)
        {
            if(patent.getMpk().size() > max.getMpk().size())
                max = patent;
        }
        return max;
    }
    public static ArrayList<Patent> createNoChaiList(ArrayList<Patent> arrayListPatents)
    {
        ArrayList<Patent> listNoChaiPatents = new ArrayList<>();
        boolean isChina = false;
        for(Patent patent: arrayListPatents)
        {

            for(String company: patent.getCompanies())
                if (company.contains("CHINA")) {
                    isChina = true;
                    break;
                }
            if (!isChina)
                listNoChaiPatents.add(patent);
            isChina = false;
        }
        return listNoChaiPatents;
    }
    public static void sortListByDateTypeA(ArrayList<Patent> listNoChaiPatents, Comparator<Patent> byDate)
    {
        listNoChaiPatents.sort(byDate);
    }

    public static TreeSet<Patent> sortListByDateTypeB(ArrayList<Patent> listNoChaiPatents, Comparator<Patent> byDate)
    {
        TreeSet<Patent> setNoChaiPatents = new TreeSet<>(byDate);
        setNoChaiPatents.addAll(listNoChaiPatents);
        return setNoChaiPatents;
    }
    public static ArrayList<String> createListPatentMpkGtOne(ArrayList<Patent> arrayListPatents)
    {
        HashMap<String, Integer> mapMpk = new HashMap<>();
        for(Patent patent: arrayListPatents) {
            for (String mpk : patent.getMpk()) {
                mapMpk.put(mpk, mapMpk.getOrDefault(mpk, 0) + 1);
            }
        }
        ArrayList<String> arrayListMpk = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: mapMpk.entrySet())
        {
            if(entry.getValue() > 1)
                arrayListMpk.add(entry.getKey());
        }
        return arrayListMpk;
    }

}
