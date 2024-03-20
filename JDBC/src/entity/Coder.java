package entity;

public class Coder {
    private int id;
    private String name;
    private String  clan;
    private int age;



    //Sirve para instanciar y luego propocionale los argumentos para que se ejecute el segundo constructor
    public Coder() {
    }
    public Coder(int id, String name, String clan, int age) {
        this.id = id;
        this.name = name;
        this.clan = clan;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Coder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", clan='" + clan + '\'' +
                ", age=" + age +
                '}';
    }
}
