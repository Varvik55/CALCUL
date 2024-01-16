import java.util.Scanner;


public class Calculator {


    public static void main(String[] args)throws Exception {

        Scanner scan = new Scanner(System.in);
        System.out.println("Ведите выражение состоящее из двух чисел(римских или арабских:)");
        String input = scan.nextLine();
        System.out.println(calc(input));
    }


    public static String calc(String input) throws Exception {

        int a;
        int b;
        String oper;
        String result;
        boolean isRoman;
        //разделитель по знакам
        String[] operands = input.split("[+\\-*/]");
        //проверка если больше трех чисел
        if(operands.length !=2 ) throw new Exception("Должно быть только два числа");
        oper = detectOperation(input);
        if (oper == null) throw new Exception("Мат операция должна быть (+ - * /)");

        if(Roman.isRoman(operands[0]) && Roman.isRoman(operands[1])){
            a=Roman.convertToArab(operands[0]);
            b=Roman.convertToArab(operands[1]);
            isRoman= true;
        } else if (!Roman.isRoman(operands[0]) && !Roman.isRoman(operands[1])) {
            a = Integer.parseInt(operands[0]);
            b = Integer.parseInt(operands[1]);
            isRoman = false;
        }else {
            throw new Exception("Числа должны быть или все арабские или все римские");
        }
        if (a>10 || b > 10){
            throw new Exception("Числа могут быть от 1 до 10");
        }
        int arabin = calcul(a,b,oper);
        if ( isRoman == true){
            if(arabin<=0 ){
                throw new Exception("Отрицательных римских чисел не существует");
            }
            result = Roman.convertToRoman(arabin);
        }else result = String.valueOf(arabin);

        return result;


    }
//метод вызвращает знак между цыфрами
    private static String detectOperation(String input) {

        if (input.contains("+"))return "+";
         else if (input.contains("-"))return "-";
        else if (input.contains("*"))return "*";
        else if (input.contains("/"))return "/";
        else return null;

    }
    static int calcul ( int a, int b, String op){
        if(op.equals("+"))return a+b;
        else if (op.equals("-")) return a-b;
        else if (op.equals("*")) return a*b;
        else return a / b;
    }



}