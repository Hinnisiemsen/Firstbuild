public class MultFun {
    AddFun add = new AddFun();
    public int mult (int a, int b) {
        int result = b;
        for (int i = 1; i < a; i++) {
            result = add.add(result, b);
        }
        return result;
    }
}
