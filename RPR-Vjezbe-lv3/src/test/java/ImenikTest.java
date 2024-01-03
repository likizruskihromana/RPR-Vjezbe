
        import org.example.FiksniBroj;
        import org.example.*;
        import org.junit.jupiter.api.BeforeAll;
        import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.function.Executable;

        import static org.junit.jupiter.api.Assertions.*;

public class ImenikTest {

    private static Imenik imenik = new Imenik();

    @BeforeAll
    public static void setup(){
        imenik.dodaj("Zijo", new MobilniBroj(61, "225-883"));
;
    }

    @Test
    public void dajBrojFound(){
        String broj = imenik.dajBroj("Merima");
        assertEquals(broj, "062524692");
    }
    @Test
    public void dajBrojNotFound(){
        String broj = imenik.dajBroj("Adnan");
        assertNull(broj);
    }


    @Test
    public void dodajFiksniException(){
        //old school
        assertThrows(BrojException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new FiksniBroj(null, "123-123");
            }
        });
        assertThrows(BrojException.class, () -> {new FiksniBroj(null, "123-123");});
    }

}