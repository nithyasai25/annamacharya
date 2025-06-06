import java.util.*;
import java.util.function.BinaryOperator;

public class MultiOperationCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("Available operators: + - * /");

            System.out.print("\nEnter the number of values: ");
            int count = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (count < 2) {
                System.out.println("At least two numbers are required.");
                continue;
            }

            System.out.println("Enter the numbers:");
            List<Double> numbers = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                numbers.add(scanner.nextDouble());
            }
            scanner.nextLine(); // consume newline
            String[] operatorSymbols = {"+", "-", "*", "/"};
            List<BinaryOperator<Double>> operations = Arrays.asList(
                (a, b) -> a + b,
                (a, b) -> a - b,
                (a, b) -> a * b,
                (a, b) -> {
                    if (b == 0) throw new ArithmeticException("Division by zero");
                    return a / b;
                }
            );
            List<String> operatorsUsed = new ArrayList<>();
            for (int i = 0; i < count - 1; i++) {
                operatorsUsed.add(operatorSymbols[i % operatorSymbols.length]);
            }
            System.out.println("\nOriginal input expression:");
            System.out.println(joinExpression(numbers, operatorsUsed));
            double result = numbers.get(0);
            try {
                for (int i = 1; i < numbers.size(); i++) {
                    int opIndex = (i - 1) % operations.size();
                    result = operations.get(opIndex).apply(result, numbers.get(i));
                }
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
            List<Double> sortedNumbers = new ArrayList<>(numbers);
            Collections.sort(sortedNumbers);

            List<String> sortedOperators = new ArrayList<>(operatorsUsed);
            Collections.sort(sortedOperators);

            System.out.println("\nSorted input expression:");
            System.out.println(joinExpression(sortedNumbers, sortedOperators));
            List<Double> evenNumbers = new ArrayList<>();
            List<Double> oddNumbers = new ArrayList<>();
            for (Double num : sortedNumbers) {
                if (((int)Math.floor(num)) % 2 == 0) {
                    evenNumbers.add(num);
                } else {
                    oddNumbers.add(num);
                }
            }

            System.out.println("\nEven numbers (sorted): " + evenNumbers);
            System.out.println("Odd numbers (sorted): " + oddNumbers);
            System.out.print("\nDo you want to perform another calculation? (yes/no): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (!answer.equals("yes") && !answer.equals("y")) {
                continueProgram = false;
                System.out.println("Thank you for using the calculator. Goodbye!");
            }
        }
    }
    private static String joinExpression(List<Double> numbers, List<String> operators) {
        StringBuilder sb = new StringBuilder();
        sb.append(numbers.get(0));
        for (int i = 0; i < operators.size(); i++) {
            sb.append(" ").append(operators.get(i)).append(" ").append(numbers.get(i + 1));
        }
        return sb.toString();
    }
}
