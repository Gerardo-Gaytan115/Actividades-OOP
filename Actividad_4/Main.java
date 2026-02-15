import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Listas en memoria
    private static final List<Materia> materias = new ArrayList<>();
    private static final List<Curso> cursos = new ArrayList<>();
    private static final List<Profesor> profesores = new ArrayList<>();
    private static final List<Alumno> alumnos = new ArrayList<>();

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean continuar = true;
        while (continuar) {
            mostrarMenuPrincipal();
            int opcion = leerEntero("Elige una opción: ");
            switch (opcion) {
                case 1 -> menuMaterias();
                case 2 -> menuCursos();
                case 3 -> menuProfesores();
                case 4 -> menuAlumnos();
                case 0 -> {
                    System.out.println("Saliendo... ¡Gracias por usar el sistema!");
                    continuar = false;
                }
                default -> System.out.println("Opción no válida.");
            }
            System.out.println();
        }
    }

    /* =========================
       Menú principal y submenús
       ========================= */
    private static void mostrarMenuPrincipal() {
        System.out.println("=======================================");
        System.out.println("      SISTEMA DE CONTROL ESCOLAR       ");
        System.out.println("=======================================");
        System.out.println("1) Materias");
        System.out.println("2) Cursos");
        System.out.println("3) Profesores");
        System.out.println("4) Alumnos");
        System.out.println("0) Salir");
    }

    private static void menuMaterias() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Materias ---");
            System.out.println("1) Crear materia");
            System.out.println("2) Listar materias");
            System.out.println("0) Volver");
            int op = leerEntero("Opción: ");
            switch (op) {
                case 1 -> crearMateria();
                case 2 -> listarMaterias();
                case 0 -> back = true;
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private static void menuCursos() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Cursos ---");
            System.out.println("1) Crear curso (requiere 3 materias)");
            System.out.println("2) Listar cursos");
            System.out.println("0) Volver");
            int op = leerEntero("Opción: ");
            switch (op) {
                case 1 -> crearCurso();
                case 2 -> listarCursos();
                case 0 -> back = true;
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private static void menuProfesores() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Profesores ---");
            System.out.println("1) Crear profesor");
            System.out.println("2) Asignar/Desasignar materia");
            System.out.println("3) Listar profesores");
            System.out.println("0) Volver");
            int op = leerEntero("Opción: ");
            switch (op) {
                case 1 -> crearProfesor();
                case 2 -> asignarMateriaAProfesor();
                case 3 -> listarProfesores();
                case 0 -> back = true;
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private static void menuAlumnos() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Alumnos ---");
            System.out.println("1) Crear alumno");
            System.out.println("2) Inscribir alumno en curso");
            System.out.println("3) Listar alumnos");
            System.out.println("0) Volver");
            int op = leerEntero("Opción: ");
            switch (op) {
                case 1 -> crearAlumno();
                case 2 -> inscribirAlumnoEnCurso();
                case 3 -> listarAlumnos();
                case 0 -> back = true;
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    /* =========================
       Operaciones: Materias
       ========================= */
    private static void crearMateria() {
        System.out.println("\nNueva Materia");
        String nombre = leerLinea("Nombre: ");
        String clave = leerLinea("Clave: ");
        int creditos = leerEnteroNoNeg("Créditos: ");
        int horas = leerEnteroNoNeg("Horas semanales: ");

        Materia m = new Materia(nombre, clave, creditos, horas);
        materias.add(m);
        System.out.println("Materia creada.");
    }

    private static void listarMaterias() {
        if (materias.isEmpty()) {
            System.out.println("No hay materias registradas.");
            return;
        }
        System.out.println("\nMaterias:");
        for (int i = 0; i < materias.size(); i++) {
            Materia m = materias.get(i);
            System.out.printf("%d) %s (%s) - Créditos: %d, Horas/Sem: %d%n",
                    i + 1, m.getNombre(), m.getClave(), m.getCreditos(), m.getHorasSemanales());
        }
    }

    /* =========================
       Operaciones: Cursos
       ========================= */
    private static void crearCurso() {
        if (materias.size() < 3) {
            System.out.println("Necesitas al menos 3 materias para crear un curso.");
            return;
        }

        System.out.println("\nNuevo Curso");
        String nombre = leerLinea("Nombre del curso: ");

        listarMaterias();
        int i1 = elegirIndice("Materia 1 (número): ", materias.size());
        int i2;
        do {
            i2 = elegirIndice("Materia 2 (número): ", materias.size());
            if (i2 == i1) System.out.println("Debe ser distinta a la Materia 1.");
        } while (i2 == i1);

        int i3;
        do {
            i3 = elegirIndice("Materia 3 (número): ", materias.size());
            if (i3 == i1 || i3 == i2) System.out.println("Debe ser distinta a las anteriores.");
        } while (i3 == i1 || i3 == i2);

        Curso c = new Curso(
                nombre,
                materias.get(i1), // El constructor de Curso hace copia interna (composición)
                materias.get(i2),
                materias.get(i3)
        );
        cursos.add(c);
        System.out.println("Curso creado.");
    }

    private static void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos registrados.");
            return;
        }
        System.out.println("\nCursos:");
        for (int i = 0; i < cursos.size(); i++) {
            Curso c = cursos.get(i);
            System.out.printf("%d) %s | Créditos Totales: %d | Horas/Sem Totales: %d%n",
                    i + 1, c.getNombre(), c.getCreditosTotales(), c.getHorasSemanalesTotales());
        }
    }

    /* =========================
       Operaciones: Profesores
       ========================= */
    private static void crearProfesor() {
        System.out.println("\nNuevo Profesor");
        String nombre = leerLinea("Nombre: ");
        String nomina = leerLinea("Número de nómina: ");
        double sueldoHora = leerDoubleNoNeg("Sueldo por hora: ");

        Materia asignada = null;
        if (!materias.isEmpty()) {
            String resp = leerLinea("¿Asignar materia ahora? (s/n): ").trim().toLowerCase();
            if (resp.startsWith("s")) {
                listarMaterias();
                int idx = elegirIndice("Elige materia (número): ", materias.size());
                asignada = materias.get(idx); // asociación: referencia
            }
        }
        Profesor p = new Profesor(nombre, nomina, sueldoHora, asignada);
        profesores.add(p);
        System.out.println("Profesor creado.");
    }

    private static void asignarMateriaAProfesor() {
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados.");
            return;
        }
        listarProfesores();
        int ip = elegirIndice("Elige profesor (número): ", profesores.size());
        Profesor p = profesores.get(ip);

        String resp = leerLinea("¿Deseas desasignar su materia? (s/n): ").trim().toLowerCase();
        if (resp.startsWith("s")) {
            p.asignarMateria(null);
            System.out.println("Materia desasignada.");
            return;
        }

        if (materias.isEmpty()) {
            System.out.println("No hay materias registradas.");
            return;
        }
        listarMaterias();
        int im = elegirIndice("Elige materia (número): ", materias.size());
        p.asignarMateria(materias.get(im));
        System.out.printf("Materia asignada. Sueldo semanal ahora: $%.2f%n", p.calcularSueldoSemanal());
    }

    private static void listarProfesores() {
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados.");
            return;
        }
        System.out.println("\nProfesores:");
        for (int i = 0; i < profesores.size(); i++) {
            Profesor p = profesores.get(i);
            String mat = (p.getMateria() == null)
                    ? "Sin materia"
                    : p.getMateria().getNombre() + " (" + p.getMateria().getClave() + ")";
            System.out.printf("%d) %s | Nómina: %s | $/hr: %.2f | Materia: %s | Sueldo semanal: $%.2f%n",
                    i + 1, p.getNombre(), p.getNumeroNomina(), p.getSueldoPorHora(), mat, p.calcularSueldoSemanal());
        }
    }

    /* =========================
       Operaciones: Alumnos
       ========================= */
    private static void crearAlumno() {
        System.out.println("\nNuevo Alumno");
        String matricula = leerLinea("Matrícula: ");
        String nombre = leerLinea("Nombre: ");
        int edad = leerEnteroNoNeg("Edad: ");

        Curso curso = null;
        if (!cursos.isEmpty()) {
            String resp = leerLinea("¿Inscribir a un curso ahora? (s/n): ").trim().toLowerCase();
            if (resp.startsWith("s")) {
                listarCursos();
                int ic = elegirIndice("Elige curso (número): ", cursos.size());
                curso = cursos.get(ic); // agregación: referencia
            }
        }
        Alumno a = new Alumno(matricula, nombre, edad, curso);
        alumnos.add(a);
        System.out.println("Alumno creado.");
    }

    private static void inscribirAlumnoEnCurso() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos registrados.");
            return;
        }
        listarAlumnos();
        int ia = elegirIndice("Elige alumno (número): ", alumnos.size());
        listarCursos();
        int ic = elegirIndice("Elige curso (número): ", cursos.size());
        alumnos.get(ia).inscribirEnCurso(cursos.get(ic));
        System.out.println("Alumno inscrito al curso.");
    }

    private static void listarAlumnos() {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        System.out.println("\nAlumnos:");
        for (int i = 0; i < alumnos.size(); i++) {
            Alumno a = alumnos.get(i);
            String cursoTxt = (a.getCurso() == null)
                    ? "Sin curso"
                    : a.getCurso().getNombre() + " (Créditos: " + a.getCurso().getCreditosTotales()
                        + ", Horas/Sem: " + a.getCurso().getHorasSemanalesTotales() + ")";
            System.out.printf("%d) %s | Matrícula: %s | Edad: %d | %s%n",
                    i + 1, a.getNombre(), a.getMatricula(), a.getEdad(), cursoTxt);
        }
    }

    /* =========================
       Utilidades de entrada
       ========================= */
    private static String leerLinea(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    private static int leerEntero(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un número entero válido.");
            }
        }
    }

    private static int leerEnteroNoNeg(String prompt) {
        int v;
        do {
            v = leerEntero(prompt);
            if (v < 0) System.out.println("Debe ser un número >= 0.");
        } while (v < 0);
        return v;
    }

    private static double leerDoubleNoNeg(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double v = Double.parseDouble(sc.nextLine().trim());
                if (v < 0) {
                    System.out.println("Debe ser un número >= 0.");
                    continue;
                }
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un número decimal válido.");
            }
        }
    }

    /** El usuario ve 1..N, devuelve índice 0..N-1. */
    private static int elegirIndice(String prompt, int size) {
        while (true) {
            int n = leerEntero(prompt);
            if (n >= 1 && n <= size) return n - 1;
            System.out.printf("Elige un número entre 1 y %d.%n", size);
        }
    }
}