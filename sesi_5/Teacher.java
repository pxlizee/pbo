public class Teacher extends Person {
    private int numCourses = 0;
    private String[] courses = new String[10]; // Kapasitas maksimal 10

    public Teacher(String name, String address) {
        super(name, address);
    }

    @Override
    public String toString() {
        return "Teacher: " + super.toString();
    }

    public boolean addCourse(String course) {
        // Cek apakah kursus sudah ada
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) {
                return false; // Kursus sudah ada
            }
        }
        courses[numCourses] = course;
        numCourses++;
        return true;
    }

    public boolean removeCourse(String course) {
        int index = -1;
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return false; // Kursus tidak ditemukan
        } else {
            // Geser elemen array untuk menghapus
            for (int i = index; i < numCourses - 1; i++) {
                courses[i] = courses[i + 1];
            }
            numCourses--;
            return true;
        }
    }
}