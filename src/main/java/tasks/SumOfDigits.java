package tasks;

public class SumOfDigits {

    private static int calculateSumOfDigits(Integer number){
        int result = 0;
        while(number > 0){
            result += number % 10;
            number = number / 10;
        }
        return result;
    }

    private static int calculateSumOfDigits(String number){
        int result = 0;
        for(char digit : number.toCharArray()){
            if(Character.isDigit(digit)) {
                result += Character.getNumericValue(digit);
            } else throw new IllegalArgumentException("Not a digit");
        }
        return result;
    }

    public static void main(String[] arg){
        System.out.println("1 + 1 + 5 = " + calculateSumOfDigits("115"));
        System.out.println("1 + 2 + 3 = " + calculateSumOfDigits(123));
        System.out.println("1 + 2 + 3 = " + calculateSumOfDigits("1ghj"));
    }

}
