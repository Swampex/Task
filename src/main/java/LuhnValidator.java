import java.util.ArrayList;

class LuhnValidator {

    boolean isValid(String candidate) {
        candidate = candidate.replace(" ", "");
        if (candidate.length()<2) {
            return false;
        }
        int sum = 0;
        Boolean doublingTrigger=false;
        for (int i=candidate.length()-1; i>=0; i--) {
            if(!Character.isDigit(candidate.charAt(i))) {
                return false;
            }
            int currentInt = Character.getNumericValue(candidate.charAt(i));
            if(doublingTrigger) {
                if(currentInt*2>9) {
                    sum += (currentInt*2)-9;
                }
                else {
                    sum += (currentInt*2);
                }
            }
            else {
                sum += currentInt;
            }
            doublingTrigger = !doublingTrigger;
        }
        return sum%10==0;
    }
}
