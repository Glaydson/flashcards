class Application {

    String name;

    void run(String[] args) {
        // implement me
        System.out.println(this.name);
        for (String a: args) {
            System.out.println(a);
        }
    }
}