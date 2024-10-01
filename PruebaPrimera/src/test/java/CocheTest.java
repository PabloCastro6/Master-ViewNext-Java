import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.prueba.vehiculo.Coche;


public class CocheTest {
    private Coche coche;



    @Test
    public void testGetMetrosRecorridos() {
        coche.avanzar(50, 120);
        assertEquals(50000, coche.getMetrosRecorridos());
    }

    @Test
    public void testGetVelocidad() {
        coche.avanzar(50, 120);
        assertEquals(120, coche.getVelocidad(), 0.01);
    }

    @Test
    public void testArrancar() {
        coche.arrancar();
        assertNotNull(coche.getTiempoInicioViaje());
    }


}

