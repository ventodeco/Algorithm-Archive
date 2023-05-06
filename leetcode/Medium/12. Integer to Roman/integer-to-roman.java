class Solution {
  List<Pair<Integer, String>> listPairRoman = new ArrayList<Pair<Integer, String>>();

  public String intToRoman(int num) {
      initListPairRoman();
      String result = "";

      for (int i = 0; i < listPairRoman.size(); i++) {
          while (num >= listPairRoman.get(i).getKey()) {
              result += listPairRoman.get(i).getValue();
              num -= listPairRoman.get(i).getKey();
          }
      }

      return result;
  }

  private void initListPairRoman() {
      listPairRoman.add(new Pair<>(1000, "M"));
      listPairRoman.add(new Pair<>(900, "CM"));
      listPairRoman.add(new Pair<>(500, "D"));
      listPairRoman.add(new Pair<>(400, "CD"));
      listPairRoman.add(new Pair<>(100, "C"));
      listPairRoman.add(new Pair<>(90, "XC"));
      listPairRoman.add(new Pair<>(50, "L"));
      listPairRoman.add(new Pair<>(40, "XL"));
      listPairRoman.add(new Pair<>(10, "X"));
      listPairRoman.add(new Pair<>(9, "IX"));
      listPairRoman.add(new Pair<>(5, "V"));
      listPairRoman.add(new Pair<>(4, "IV"));
      listPairRoman.add(new Pair<>(1, "I"));
  }
}
