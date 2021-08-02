
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double total;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<com.nttdata.academy.models.ItemModel> items = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<com.nttdata.academy.models.ItemModel> getItems() {
        return items;
    }

    public void setItems(List<com.nttdata.academy.models.ItemModel> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "id=" + id +
                ", total=" + total +
                ", items=" + items +
                '}';
    }
}