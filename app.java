import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class app {

    public static void main(String[] args) {
        Map<String, Map<String, Integer>> generalPlaylist = new HashMap<>();
        
        Map<String,Integer> tracksForRap = new HashMap<String, Integer>();
        Map<String,Integer> tracksForTrap = new HashMap<String, Integer>();
        Map<String,Integer> tracksForIndi = new HashMap<String, Integer>();
        Map<String,Integer> tracksForDisco = new HashMap<String, Integer>();


        String[] RapSongs = {"Ball w/0 u", "10 freaky girls", "Humble", "Swimming Pools", "Money Trees", "Stay", "Yeah", "Self Care", "Lost it", "She knows"};
        String[] TrapSongs = {"151 rum", "Fake Love", "Sunday", "HONEST", "CANT HAVE IT", "Love and War", "Stuck in Admiration", "Beware", "DM - Remix", "Im good Luv, Enjoy"};
        String[] IndiSongs = {"Stunner", "Sweater Weather", "Something good", "Imagination", "Cryptic Captions", "Eventually", "I THINK", "Tick Tock", "Hell N Back", "August"};
        String[] DiscoSongs = {"Outside", "Cooler Than me", "West End Girls", "Sexy Bitch", "Get Lucky", "Stole the show", "Crazy", "Maps", "Summer", "My Way"};
        
        generalPlaylist.put("Rap", CreatePlayListMap(tracksForRap, RapSongs, 100000));
        generalPlaylist.put("Trap", CreatePlayListMap(tracksForTrap, TrapSongs, 100000));
        generalPlaylist.put("Indi", CreatePlayListMap(tracksForIndi, IndiSongs, 100000));
        generalPlaylist.put("Disco", CreatePlayListMap(tracksForDisco, DiscoSongs, 100000));
        

        Map<String, Integer> HappyPlaylist = new HashMap<>();
        Map<String, Integer> HypePlaylist = new HashMap<>();
        Map<String, Integer> DancingPlaylist = new HashMap<>();
        
        HappyPlaylist.put("Ball w/0 u", tracksForRap.get("Ball w/0 u"));
        HappyPlaylist.put("Money Trees", tracksForRap.get("Money Trees"));
        HappyPlaylist.put("Stuck in Admiration", tracksForTrap.get("Stuck in Admiration"));
        HappyPlaylist.put("Stunner", tracksForIndi.get("Stunner"));
        HappyPlaylist.put("I THINK", tracksForIndi.get("I THINK"));
        HappyPlaylist.put("August", tracksForIndi.get("August"));
        HappyPlaylist.put("Maps", tracksForDisco.get("Maps"));
        HappyPlaylist.put("My Way", tracksForDisco.get("My Way"));
        HappyPlaylist.put("Get Lucky", tracksForDisco.get("Get Lucky"));
        HappyPlaylist.put("Coller than me", tracksForDisco.get("Cooler Than me"));

        HypePlaylist.put("10 freaky girls", tracksForRap.get("10 freaky girls"));
        HypePlaylist.put("Lost it", tracksForRap.get("Lost it"));
        HypePlaylist.put("She knows", tracksForRap.get("She knows"));
        HypePlaylist.put("Eventually", tracksForIndi.get("Eventually"));
        HypePlaylist.put("Cryptic Captions", tracksForIndi.get("Cryptic Captions"));
        HypePlaylist.put("151 rum", tracksForTrap.get("151 rum"));
        HypePlaylist.put("DM - Remix", tracksForTrap.get("DM - Remix"));
        HypePlaylist.put("Im good Luv, Enjoy", tracksForTrap.get("Im good Luv, Enjoy"));
        HypePlaylist.put("HONEST", tracksForTrap.get("HONEST"));
        HypePlaylist.put("Fake Love", tracksForTrap.get("Fake Love"));

        DancingPlaylist.put("Sexy Bitch", tracksForDisco.get("Sexy Bitch"));
        DancingPlaylist.put("Stole the show", tracksForDisco.get("Stole the show"));
        DancingPlaylist.put("Outside", tracksForDisco.get("Outside"));
        DancingPlaylist.put("Cooler than me", tracksForDisco.get("Cooler Than me"));
        DancingPlaylist.put("Crazy", tracksForDisco.get("Crazy"));
        DancingPlaylist.put("Sweater Weather", tracksForIndi.get("Sweater Weather"));
        DancingPlaylist.put("Tick Tock", tracksForIndi.get("Tick Tock"));
        DancingPlaylist.put("Hell N Back", tracksForIndi.get("Hell N Back"));
        DancingPlaylist.put("August", tracksForIndi.get("August"));
        DancingPlaylist.put("Yeah", tracksForRap.get("Yeah"));
        
        

        LinkedHashMap<String, Integer> SortedHappyPlaylist = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> SortedHypePlaylist = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> SortedDancingPlaylist = new LinkedHashMap<>();

        Map<String, Integer> resultSortedHappyPlaylist = sortingMaps(HappyPlaylist, SortedHappyPlaylist);
        Map<String, Integer> resultSortedHypePlaylist = sortingMaps(HypePlaylist, SortedHypePlaylist);
        Map<String, Integer> resultSortedDancingPlaylist = sortingMaps(DancingPlaylist, SortedDancingPlaylist);

        UiInterface(resultSortedHappyPlaylist, resultSortedHypePlaylist, resultSortedDancingPlaylist);

    }

   public static int timesListened(int maxBound) {
        Random rand = new Random();
        int countListen = rand.nextInt(maxBound);
        return countListen;
    }
 
    public static Map<String,Integer> CreatePlayListMap(Map<String, Integer> MapOfPlaylist, String[] arrayOfSongs, int maxBound) {
        for (int i = 0; i < 10; i++) {
            MapOfPlaylist.put(arrayOfSongs[i], timesListened(maxBound));
        }
        return MapOfPlaylist;
    }

    
    public static void UiInterface(Map<String, Integer> resultSortedHappyPlaylist, Map<String, Integer> resultSortedHypePlaylist, Map<String, Integer> resultSortedDancingPlaylist) {
        System.out.println("Hello my friend, how are you feeling today? 1. Happy 2. Hyped 3. Energetically (Please type a number)");
        Scanner scan = new Scanner(System.in);
        String answer = scan.nextLine();
        while(!answer.equals("1") && !answer.equals("2") && !answer.equals("3")) {
            System.out.println("You entered wrong number or symbol, please try again: ");
            answer = scan.nextLine();
        }
        while(answer.equals("1")) {
            System.out.println("Okey my friend, I made this playlist with happy songs, sorted by popularity");
            for (Map.Entry<String, Integer> entry : resultSortedHappyPlaylist.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue().toString());
            }
            System.out.println("Do you want to play a \n 1. specific song \n 2. random song \n (Please type a number) ");
            String whichSong = scan.nextLine();
            if (whichSong.equals("1")) {
                System.out.println("What song do you want to play? ");
                String whatsong = scan.nextLine();
                while (resultSortedHappyPlaylist.containsKey(whatsong) == false) {
                    System.out.println("Oups, this song doesnt exist in this playlist, please try again: ");
                    whatsong = scan.nextLine();
                }
                if (resultSortedHappyPlaylist.containsKey(whatsong) == true) {
                    System.out.println("Now you are listening to " + whatsong);
                    break;
                }
                
            }
            if (whichSong.equals("2")) {
               System.out.println("Now is playing " + printRandomMapKeyValueElement(resultSortedHappyPlaylist));
               break;
                
            }
        }
        while (answer.equals("2")) {
            System.out.println("Okey my friend, I made this playlist with hype songs, sorted by popularity");
            for (Map.Entry<String, Integer> entry : resultSortedHypePlaylist.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue().toString());
            }
            System.out.println("Do you want to play a \n 1. specific song  \n 2. random song \n (Please type a number) ");
            String whichSong2 = scan.nextLine();
            if (whichSong2.equals("1")) {
                System.out.println("What song do you want to play? ");
                String whatsong2 = scan.nextLine();
                while (resultSortedHypePlaylist.containsKey(whatsong2) == false) {
                    System.out.println("Oups, this song doesnt exist in this playlist, please try again: ");
                    whatsong2 = scan.nextLine();
                }
                if (resultSortedHypePlaylist.containsKey(whatsong2) == true) {
                    System.out.println("Now you are listening to " + whatsong2);
                    break;
                }
                
            }
            if (whichSong2.equals("2")) {
               System.out.println("Now is playing " + printRandomMapKeyValueElement(resultSortedHypePlaylist));
               break;
                
            }
        }
        while (answer.equals("3")) {
            System.out.println("Okey my friend, I made this playlist with dancing songs, sorted by popularity");
            for (Map.Entry<String, Integer> entry : resultSortedDancingPlaylist.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue().toString());
            }
            System.out.println("Do you want to play a \n 1. specific song  \n 2. random song \n (Please type a number) ");
            String whichSong3 = scan.nextLine();
            if (whichSong3.equals("1")) {
                System.out.println("What song do you want to play? ");
                String whatsong3 = scan.nextLine();
                while (resultSortedDancingPlaylist.containsKey(whatsong3) == false) {
                    System.out.println("Oups, this song doesnt exist in this playlist, please try again: ");
                    whatsong3 = scan.nextLine();
                }
                if (resultSortedDancingPlaylist.containsKey(whatsong3) == true) {
                    System.out.println("Now you are listening to " + whatsong3);
                    break;
                }
                
            }
            if (whichSong3.equals("2")) {
               System.out.println("Now is playing " + printRandomMapKeyValueElement(resultSortedDancingPlaylist));
                break;
            }
        }
        scan.close();
    }
    public static Map<String, Integer> sortingMaps(Map<String, Integer> anyMap, Map<String, Integer> newSortedMap) {
        anyMap.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
        .forEachOrdered(x -> newSortedMap.put(x.getKey(), x.getValue()));
        return newSortedMap;
    }

    public static String printRandomMapKeyValueElement(Map<String, Integer> anyMap) {
        Set<String> keySet = anyMap.keySet();
        List<String> keyList = new ArrayList<>(keySet);

        int size = keyList.size();
        int randIdx = new Random().nextInt(size);

        String randomKey = keyList.get(randIdx);
        return randomKey;
    }
    
}
