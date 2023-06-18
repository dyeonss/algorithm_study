class Solution {
    public String solution(String phone_number) {
        String answer = "";
      
        phone_number=phone_number.replace(phone_number.substring(0,phone_number.length()-4),"*".repeat(phone_number.length()-4));
        
        return phone_number;
    }
}