import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.prueba.vehiculo.Coche;


public class CocheTest {
    private Coche coche;

    @BeforeEach
    public void setUp() {
        coche = new Coche("Matricula", "Color");
    }

    @Test
    public void testGetMetrosRecorridos() {
    	Coche coche = new Coche("Matricula", "Color");
        coche.avanzar(50, 120);
        assertEquals(50000, coche.getMetrosRecorridos());
    }

    @Test
    public void testGetVelocidad() {
    	Coche coche = new Coche("Matricula", "Color");
        coche.avanzar(50, 120);
        assertTrue(coche.getVelocidad() >= 119.99 && coche.getVelocidad() <= 120.01); //Afirmacion assert para verificar si es verdadera la condicion
    }

    @Test
    public void testArrancar() {
    	Coche coche = new Coche("Matricula", "Color");
        coche.arrancar();
        assertNotNull(coche.getTiempoInicioViaje());
    }


}

