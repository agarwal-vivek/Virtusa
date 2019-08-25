 public class NumberToWordConverter  
 
{
    private static final String[] specialNames = {
        "",
        " thousand",
        " million",
        " billion",
        " trillion",
        " quadrillion",
        " quintillion"
    };
    
    private static final String[] tensNames = {
        "",
        " ten",
        " twenty",
        " thirty",
        " forty",
        " fifty",
        " sixty",
        " seventy",
        " eighty",
        " ninety"
    };
    
    private static final String[] numNames = {
        "",
        " one",
        " two",
        " three",
        " four",
        " five",
        " six",
        " seven",
        " eight",
        " nine",
        " ten",
        " eleven",
        " twelve",
        " thirteen",
        " fourteen",
        " fifteen",
        " sixteen",
        " seventeen",
        " eighteen",
        " nineteen"
    };
    
    private String convertLessThanOneThousand(int number) {
        String ones;
        
        if (number % 100 < 20){
        	ones = numNames[number % 100];
            number /= 100;
        }
        else {
        	ones = numNames[number % 10];
            number /= 10;
            
            ones = tensNames[number % 10] + ones;
            number /= 10;
        }
        if (number == 0) return ones;
        return numNames[number] + " hundred" + ones;
    }
    
    public String convertToword(int number) {

        if (number == 0) { return "zero"; }
        
        String prefix = "";
        
        if (number < 0) {
            number = -number;
            prefix = "negative";
        }
        
        String ones = "";
        int place = 0;
        
        do {
            int n = number % 1000;
            if (n != 0){
                String s = convertLessThanOneThousand(n);
                ones = s + specialNames[place] + ones;
            }
            place++;
            number /= 1000;
        } while (number > 0);
        
        return (prefix + ones).trim();
    }
    
    public static void main(String[] args) {
        NumberToWordConverter obj = new NumberToWordConverter();
        System.out.println(" 21 =  " + obj.convertToword(21));
        System.out.println("105 = " + obj.convertToword(105));
        System.out.println("56945781 = " + obj.convertToword(56945781));
        System.out.println(" -55 = " + obj.convertToword(-55));
    }
}