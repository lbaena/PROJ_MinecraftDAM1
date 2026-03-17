package lbaena.projecteminecraft.fitxers;

import lbaena.projecteminecraft.fitxers.MeuObjecteOutputStream;
import lbaena.projecteminecraft.fitxers.ObjecteAComparar;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fitxers {
    private String rutaArxiu;

    public Fitxers(String rutaArxiu) {
        this.rutaArxiu = rutaArxiu;
    }

    public Fitxers() {
    }

    public String getRutaArxiu() {
        return this.rutaArxiu;
    }

    public void setRutaArxiu(String rutaArxiu) {
        this.rutaArxiu = rutaArxiu;
    }

    /** @deprecated */
    @Deprecated
    public void escriuFitxerTextIO(String text, boolean afegir) {
        try {
            try (FileWriter out = new FileWriter(this.rutaArxiu, afegir)) {
                out.write(text + "\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /** @deprecated */
    @Deprecated
    public String[] retornaFitxerTextIOArray() {
        int maxLinies = 0;

        try (
                FileReader in1 = new FileReader(this.rutaArxiu);
                Scanner input1 = new Scanner(in1);
        ) {
            while(input1.hasNextLine()) {
                String linia = input1.nextLine();
                ++maxLinies;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Fitxer no trobat: " + this.rutaArxiu, e);
        } catch (IOException e) {
            throw new RuntimeException("Error de lectura/escriptura", e);
        }

        String[] linies = new String[maxLinies];

        try {
            try (
                    FileReader in2 = new FileReader(this.rutaArxiu);
                    Scanner input2 = new Scanner(in2);
            ) {
                for(int i = 0; input2.hasNextLine(); ++i) {
                    String linia = input2.nextLine();
                    linies[i] = linia;
                }
            }

            return linies;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Fitxer no trobat: " + this.rutaArxiu, e);
        } catch (IOException e) {
            throw new RuntimeException("Error de lectura/escriptura", e);
        }
    }

    /** @deprecated */
    @Deprecated
    public List<String> retornaFitxerTextIO() {
        List<String> linies = new ArrayList();

        try {
            try (FileReader in = new FileReader(this.rutaArxiu)) {
                Scanner input = new Scanner(in);

                while(input.hasNextLine()) {
                    String linia = input.nextLine();
                    linies.add(linia);
                }
            }

            return linies;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void escriuObjecteFitxer(Object obj, boolean afegir) throws IOException {
        if (afegir && this.existeix(this.rutaArxiu)) {
            MeuObjecteOutputStream out = new MeuObjecteOutputStream(new FileOutputStream(this.rutaArxiu, afegir));
            out.writeObject(obj);
            out.close();
            Object var6 = null;
        } else {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.rutaArxiu, afegir));
            out.writeObject(obj);
            out.close();
            out = null;
        }

    }

    /** @deprecated */
    @Deprecated
    public List<Object> retornaObjectesFitxer() {
        List<Object> lObjs = new ArrayList();

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.rutaArxiu));

            do {
                Object obj = in.readObject();
                lObjs.add(obj);
            } while(in != null);

            in.close();
            ObjectInputStream var5 = null;
        } catch (Exception var4) {
        }

        return lObjs;
    }

    public Object cercaObjecteFitxer(ObjecteAComparar obj) throws InterruptedException, IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        List<Object> lObjs = this.cercaObjectesFitxer(obj);
        return lObjs == null ? null : lObjs.get(0);
    }

    public List<Object> cercaObjectesFitxer(ObjecteAComparar obj) throws IOException, InterruptedException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        List<Object> LObj = this.retornaObjectesFitxer();
        List<Object> LObjectesTrobat = new ArrayList();
        boolean trobat = false;

        for(int i = 0; i < LObj.size(); ++i) {
            Object objFitxer = LObj.get(i);
            if (objFitxer.equals(obj)) {
                LObjectesTrobat.add(objFitxer);
                trobat = true;
            }
        }

        if (!trobat) {
            return null;
        } else {
            return LObjectesTrobat;
        }
    }

    public void eliminaRegistreFitxerObjecte(ObjecteAComparar Obj) throws InterruptedException, IOException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        List<Object> LObj = this.retornaObjectesFitxer();
        boolean primerRegistreGravat = true;

        for(int i = 0; i < LObj.size(); ++i) {
            if (LObj.size() == 1 && LObj.get(i).equals(Obj)) {
                this.eliminarFitxerDirectori();
            } else if (!LObj.get(i).equals(Obj)) {
                if (primerRegistreGravat) {
                    this.escriuObjecteFitxer(LObj.get(i), false);
                    primerRegistreGravat = false;
                } else {
                    this.escriuObjecteFitxer(LObj.get(i), true);
                }
            }
        }

    }

    public <T> Object retornaObjectesFitxer(T classe) {
        List<T> LObjs = new ArrayList();

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.rutaArxiu));

            do {
                T obj = (T)in.readObject();
                LObjs.add(obj);
            } while(in != null);

            in.close();
            Object e = null;
        } catch (IOException var5) {
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return LObjs;
    }

    public void escriuFitxerText(String text, String charset, boolean afegir) throws IOException {
        Path path = Paths.get(this.rutaArxiu);
        List<StringBuffer> dades = new ArrayList();
        dades.add(new StringBuffer(text));
        if (afegir) {
            Files.write(path, dades, Charset.forName(charset), Files.exists(path, new LinkOption[0]) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
        } else {
            Files.write(path, dades, Charset.forName(charset));
        }

    }

    public void escriuFitxerText(String text, boolean afegir) throws IOException {
        this.escriuFitxerText(text, "UTF-8", afegir);
    }

    public List<String> retornaFitxerText() throws IOException, InterruptedException {
        return this.retornaFitxerText("UTF-8");
    }

    public List<String> retornaFitxerText(String charset) throws IOException, InterruptedException {
        Path path = Paths.get(this.rutaArxiu);
        List<String> llista = new ArrayList();
        if (this.existeix(this.rutaArxiu)) {
            Charset jocCaracter = Charset.forName(charset);
            BufferedReader reader = Files.newBufferedReader(path, jocCaracter);

            String linia;
            while((linia = reader.readLine()) != null) {
                llista.add(linia);
            }
        } else {
            Thread.sleep(5L);
            System.err.println("El fitxer " + this.rutaArxiu + " NO existeix");
        }

        return llista;
    }

    public void mostraContingutFitxer() throws IOException, InterruptedException {
        List<String> contingut = this.retornaFitxerText();

        for(int i = 0; i < contingut.size(); ++i) {
            System.out.println((String)contingut.get(i));
        }

    }

    public boolean existeix(String rutaArxiu) {
        Path path = Paths.get(rutaArxiu);
        return Files.exists(path, new LinkOption[0]);
    }

    public boolean existeix() {
        return this.rutaArxiu.length() < 3 ? false : this.existeix(this.rutaArxiu);
    }

    public void creaDirectori() throws IOException {
        Path path = Paths.get(this.rutaArxiu);
        Files.createDirectory(path);
    }

    public String propietariFitxer() throws IOException {
        Path path = Paths.get(this.rutaArxiu);
        UserPrincipal propietari = Files.getOwner(path);
        return propietari.toString();
    }

    public void eliminarFitxerDirectori() throws IOException {
        Path path = Paths.get(this.rutaArxiu);
        if (!Files.exists(path, new LinkOption[0])) {
            System.err.println("Advertència: El fitxer ja estava eliminat -> " + this.rutaArxiu);
        } else {
            System.gc();
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException var6) {
                    Thread.currentThread().interrupt();
                }
            }

            for(int i = 0; i < 5; ++i) {
                try {
                    Files.delete(path);
                    return;
                } catch (NoSuchFileException var7) {
                    System.err.println("Error: El fitxer no existeix -> " + this.rutaArxiu);
                    return;
                } catch (DirectoryNotEmptyException var8) {
                    System.err.println("Error: El directori no està buit -> " + this.rutaArxiu);
                    return;
                } catch (IOException e) {
                    System.err.println("Intent " + (i + 1) + ": No es pot eliminar el fitxer -> " + e.getMessage());

                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException var5) {
                        Thread.currentThread().interrupt();
                    }
                }
            }

            System.err.println("Error: No s'ha pogut eliminar el fitxer després de diversos intents.");
        }

    }

    public void eliminarFitxerDirectoriPle(boolean segur) {
        if (!segur) {
            System.out.println("Eliminació cancel·lada per seguretat.");
        } else {
            Path path = Paths.get(this.rutaArxiu);
            if (!Files.exists(path, new LinkOption[0])) {
                System.out.println("El directori no existeix.");
            } else {
                System.gc();
                if (System.getProperty("os.name").toLowerCase().contains("win")) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException var5) {
                        Thread.currentThread().interrupt();
                    }
                }

                try {
                    Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                            try {
                                Files.delete(file);
                            } catch (IOException e) {
                                PrintStream var10000 = System.err;
                                String var10001 = String.valueOf(file);
                                var10000.println("Error eliminant fitxer: " + var10001 + " -> " + e.getMessage());
                            }

                            return FileVisitResult.CONTINUE;
                        }

                        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                            try {
                                Files.delete(dir);
                            } catch (IOException e) {
                                PrintStream var10000 = System.err;
                                String var10001 = String.valueOf(dir);
                                var10000.println("Error eliminant directori: " + var10001 + " -> " + e.getMessage());
                            }

                            return FileVisitResult.CONTINUE;
                        }
                    });
                } catch (IOException e) {
                    System.err.println("Error eliminant el directori: " + e.getMessage());
                }

            }
        }
    }

    public void copiarFitxerDirectori(String origen, String desti) throws IOException {
        Path pathOrigen = Paths.get(origen);
        Path pathDesti = Paths.get(desti);
        Files.copy(pathOrigen, pathDesti, StandardCopyOption.REPLACE_EXISTING);
    }

    public void moureFitxerDirectori(String origen, String desti) throws IOException {
        Path pathOrigen = Paths.get(origen);
        Path pathDesti = Paths.get(desti);
        Files.move(pathOrigen, pathDesti, StandardCopyOption.REPLACE_EXISTING);
    }

    public String metadadesFitxer() throws IOException {
        String cadena;
        if (this.existeix(this.rutaArxiu)) {
            Path path = Paths.get(this.rutaArxiu);
            cadena = String.valueOf(Files.size(path));
            cadena = cadena + ";" + Files.isDirectory(path, new LinkOption[0]);
            cadena = cadena + ";" + Files.isRegularFile(path, new LinkOption[0]);
            cadena = cadena + ";" + Files.isSymbolicLink(path);
            cadena = cadena + ";" + Files.isHidden(path);
            cadena = cadena + ";" + String.valueOf(Files.getLastModifiedTime(path));
            cadena = cadena + ";" + String.valueOf(Files.getOwner(path));
        } else {
            cadena = "No existeix el fitxer";
        }

        return cadena;
    }
}
