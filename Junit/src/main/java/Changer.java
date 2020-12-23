public class Changer {
    // متد استاتیکی که یک ورودی استرینگ میگیرد و در صورت معتبر بودن آن را تبدیل به اینتجر میکند
    public static Integer toInteger(String str) {
        //(int)'1' to (int)'9' => 49 to 57
        int result = 0;
        boolean isNegative = false;
        // چک کردن نال نبودن داده
        if (str == null)
            throw new NullPointerException("not changeable to Integer");

        // چک کردن اینکه عدد منفی است یا مثبت و برداشتن علامت(در صورت منفی بودن isNegative مقدار true میگیرد)
        if ((str.charAt(0) == '-' || str.charAt(0) == '+')) {
            if (str.charAt(0) == '-')
                isNegative = true;
            str = str.substring(1);
        }

        // در صورتی که اعداد اول صفر باشند حذف میشوند مگر فقط یک صفر باقی بماند
        while (str.charAt(0) == '0' && str.length()!= 1){
            str = str.substring(1);
        }
        // در صورت فیلتر های بالا عدد ما ماکسیمم میتواند 5 رقمی باشد
        if (str.length() > 5)
            throw new NumberFormatException("not changeable to Integer");

        // چک کردن این 5 رقم که فقط 0 تا 9 باشند
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9')
                throw new NumberFormatException("not changeable to Integer");
        }

        // محاسبه مقدار عددی
        for (int i = 0; i < str.length(); i++) {
            result += ((int) (str.charAt(i)) - 48) * ((int) Math.pow(10, str.length() - i - 1));
        }

        //چک کردن نهایی که بازه عدد 5 رقمی ما در رنج باشد
        if ((result > 32767 && !isNegative) || (result > 32768 && isNegative))
            throw new NumberFormatException("not changeable to Integer");

        // در نهایت اضافه کردن علامت و return کردن مقدار
        return isNegative ? -1 * result : result;
    }


    // این متد در کلاس Integer در خود جاوا وجود دارد که میشد برای راحتی از آن استفاده کرد
    public static Integer toIntegerWithJava(String str) {
        return Integer.parseInt(str);
    }

    // این متد در کلاس Integer در خود جاوا وجود دارد که میشد برای راحتی از آن استفاده کرد
    public static Integer toIntegerWithJava2(String str) {
        return Integer.valueOf(str);
    }
}
