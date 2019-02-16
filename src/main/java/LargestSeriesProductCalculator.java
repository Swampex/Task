class LargestSeriesProductCalculator {
    private String input;

    LargestSeriesProductCalculator(String inputNumber) {
        for(int i=0; i<inputNumber.length(); i++) {
            if (!Character.isDigit(inputNumber.charAt(i))) {
                throw new IllegalArgumentException("String to search may only contain digits.");
            }
        }
        this.input = inputNumber;
    }

    long calculateLargestProductForSeriesLength(int numberOfDigits) {
        long largestProduct = 0;
        if (numberOfDigits>input.length() ) {
            throw new IllegalArgumentException("Series length must be less than " +
                    "or equal to the length of the string to search.");
        }
        if (numberOfDigits<0) {
            throw new IllegalArgumentException("Series length must be non-negative.");
        }
        for (int i=0; i<input.length()-numberOfDigits+1; i++) {
            long currentProduct = calculateProduct(input.substring(i, i+numberOfDigits));
            if (currentProduct>largestProduct) {
                largestProduct = currentProduct;
            }
        }
        return largestProduct;
    }

    private long calculateProduct(String digits) {
        long product = 1;
        for(int i=0; i<digits.length(); i++) {
            product *= Character.getNumericValue(digits.charAt(i));
        }
        return product;
    }
}