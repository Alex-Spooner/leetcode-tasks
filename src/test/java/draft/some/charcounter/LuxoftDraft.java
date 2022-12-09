package draft.some.charcounter;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LuxoftDraft {

    public void doSomethingWithString(String test){
        Set<Character> numbersAndSpace = Set.of('0','1','2','3','4','5','6','7','8','9', ' ');
        List<Character> characterList = new ArrayList<>();
        for (char c : test.toCharArray()) {
            characterList.add(c);
        }
        Map<Character, List<Character>> charactersMap = characterList.stream()
                .filter(o -> !numbersAndSpace.contains(o))
                .collect(Collectors.groupingBy(
                        chr -> chr, Collectors.toList()
                ));
        charactersMap.forEach((key, value) -> System.out.printf("Character %c, count %d %n", key, value.size()));
    }

    @Test
    public void test() {
        doSomethingWithString("abc abc xyz 123");
    }

    @Test
    public void test1(){
        List<Integer> integers = new ArrayList<>(List.of(1,2,3,4,5,6,6,6));
        List<Integer> integersToDelete = List.of(6);
        integers.removeAll(integersToDelete);
        System.out.printf(integers.toString());
    }

    //String s="abc abc xyz 123"
    //1) Remove spaces and numbers from string
    //2) Print character wise count
    //using java8 stream API
    //Stream traverse should be only once
}
