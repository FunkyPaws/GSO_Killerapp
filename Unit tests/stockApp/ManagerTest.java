package stockApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Manager manager;
    Manager manager2;
    Manager manager3;
    String k;

    @BeforeEach
    void setUp() {
        manager = new Manager("manager", "manager", "Henk Ietsens");
        manager2 = new Manager("manager", "manager", "Henk Ietsens");
        manager3 = new Manager("bert", "bert", "Henk Ietsens");
        k = "iets";
    }

    @Test
    void getLoginName() {
        String s = "manager";
        assertEquals(s, manager.getLoginName());

        String h = "henk";
        assertNotEquals(h, manager.getLoginName());
    }

    @Test
    void getPassword() {
        String s = "manager";
        assertEquals(s, manager.getPassword());

        String h = "henk";
        assertNotEquals(h, manager.getPassword());
    }

    @Test
    void getName() {
        String s = "Henk Ietsens";
        assertEquals(s, manager.getName());

        String h = "henk";
        assertNotEquals(h, manager.getName());
    }

    @Test
    void checkLogin() {
        boolean b = false;
        if (manager.checkLogin(manager.getLoginName(), manager.getPassword())) {
            b = true;
        }
        assertTrue(b);

        boolean c = true;
        if (!manager.checkLogin(k, manager.getPassword())){
            c = false;
        }
        assertFalse(c);
    }

    @Test
    void equals() {
        assertTrue(manager.equals(manager2));
        assertFalse(manager2.equals(manager3));
    }
}