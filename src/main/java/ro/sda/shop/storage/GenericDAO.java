package ro.sda.shop.storage;

//import ro.sda.shop.model.T;
import ro.sda.shop.model.Entity;

import java.util.ArrayList;
import java.util.List;

public abstract class  GenericDAO<T extends Entity> {
    protected abstract List<T> getItems();

    public List<T> findAll(){
        return getItems();
    }

    public T findById(Long id){
        boolean itemExist = false;
        for(T item : getItems()){
            if(item.getId().equals(id)){
                return item;
            }
        }
        return null;
    }

    public void update(T item){
        delete(item);
        add(item);
    }

    public T add(T item){
        if(item.getId() == null) {
            item.setId(generateNewId());
        }
        getItems().add(item);
        return item;
    }

    public void delete(T item){
        deleteById(item.getId());
    }

    public boolean deleteById(Long id){
        T deleteItem = null;
        for(T item : getItems()){
            if(item.getId().equals(id)){
                deleteItem = item;
            }
        }
        return getItems().remove(deleteItem);
    }

    private Long generateNewId(){
        return findMaxId() + 1;
    }

    private Long findMaxId(){
        Long max = -1L;
        for(T item : getItems()){
            if(max < item.getId()){
                max = item.getId();
            }
        }
        return max;
    }
}