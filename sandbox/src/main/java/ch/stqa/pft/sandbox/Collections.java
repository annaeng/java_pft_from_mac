package ch.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by annaryapolova on 14.04.17.
 */
public class Collections {

  public static void main(String[] args) {
    String[] langs = {"Java", "C#", "Python", "PHP"};

    List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

    for (String l :languages) {
      System.out.println("Я хочу выучить " + l);
    }
  }
}
