package algorithms.hash;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableWithNoCollisionTest {
    HashTableWithNoCollision hashTableWithNoCollision;

    @BeforeEach
    void setUp() {
        this.hashTableWithNoCollision = new HashTableWithNoCollision();
        this.hashTableWithNoCollision.insert("Seunghwan", 10);
        this.hashTableWithNoCollision.insert("Hwanseung", 20);
    }

    @DisplayName("Hash collision resolved")
    @Test
    void hashCollisionTest() {
        assertEquals(10, this.hashTableWithNoCollision.get("Seunghwan"));
        assertEquals(20, this.hashTableWithNoCollision.get("Hwanseung"));
    }
}