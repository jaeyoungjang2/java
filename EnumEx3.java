public enum EnumEx3 {
    SUNDAY(WEEKEND), MONDAY(WEEKEND);

    private final TypePay typePay;

    EnumEx3(TypePay typePay) {
        this.typePay = typePay;
    }

    enum TypePay {
        WEEKEND {
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked <= 4 ? 0 : (minsWorked - 4) * payRate * 2;
            }
        }
    }
}
