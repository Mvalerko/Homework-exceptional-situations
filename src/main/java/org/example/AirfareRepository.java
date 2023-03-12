package org.example;

public class AirfareRepository {
    private Airfare[] items = new Airfare[0];

    public void save(Airfare item) {
        Airfare[] tmp = new Airfare[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public void removeById(int idOpt) {

        for (Airfare ticket : items) {
            if (matches(ticket, idOpt)) {
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

