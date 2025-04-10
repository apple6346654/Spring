package jpabook.jpashop.domain;

import jakarta.persistence.*;
import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
public class Category {

    @Id @GeneratedValue
    @Column(name = "Category_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "Category_item",
     joinColumns = @JoinColumn(name = "category_id"),
     inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> items = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent") //parent와 양방향 관계
    private List<Category> Child = new ArrayList<>();

    //연관관계 메서드
    public void  addChildCategory(Category child) {
        this.Child.add(child);
        child.setParent(this);
    }

}
