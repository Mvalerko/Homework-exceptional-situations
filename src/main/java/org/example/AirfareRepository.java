package org.example;

public class AirfareRepository {
    private Airfare[] items = new Airfare[0];

    public void save(Airfare item) {

        if (findById(item.id) != null) {
            System.out.println("При попытке добавить авиабилет в массив вы указали продукт с уже существующим в массиве id(" + item.id + ")" +
                    " Операция не выполнена. В массиве остался только один авиабилет с id(" + item.id + ")");
        } else {
            Airfare[] tmp = new Airfare[items.length + 1];
            for (int i = 0; i < items.length; i++) {
                tmp[i] = items[i];
            }
            tmp[tmp.length - 1] = item;
            items = tmp;
        }
    }

    public void removeById(int idOpt) {

        for (Airfare ticket : items) {

            if (findById(idOpt) == null) {
                System.out.println("При попытке удаления ячейки из массива Вы ввели несуществующий id(" + idOpt + ") авибилета." +
                        " Операция не выполнена.");
            } else {

                Airfare[] tmp = new Airfare[items.length - 1];
                int copyToIndex = 0;
                for (Airfare item : items) {
                    if (item.getId() != idOpt) {
                        tmp[copyToIndex] = item;
                        copyToIndex++;

                    }
                }
                items = tmp;
            }
        }
    }

    public Airfare findById(int idOpt) {

        for (Airfare product : items) {
            if (matches(product, idOpt)) {
                return product;
            }
        }
        return null;
    }

    public boolean matches(Airfare ticket, int search) {
        if (ticket.getId() == search) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }

    public Airfare[] getItems() {
        return items;
    }

}
