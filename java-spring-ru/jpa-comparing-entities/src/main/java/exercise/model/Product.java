package exercise.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import static jakarta.persistence.GenerationType.IDENTITY;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

// BEGIN
@Getter
@Setter
@EqualsAndHashCode(of = {"title", "price"})
@Table(name = "products")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    private int price;

    private String title;
}
// END
