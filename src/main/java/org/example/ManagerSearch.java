package org.example;

public class ManagerSearch {
    AirfareRepository repo = new AirfareRepository();

    public ManagerSearch(AirfareRepository repo) {

    }

    public void add(Airfare managerOption) {
        repo.save(managerOption);
    }

    public void removeById(int removeOpt) {
        repo.removeById(removeOpt);
    }

    public Airfare[] findAll() {
        return repo.getItems();
    }

    public Airfare[] findAllSearch(String from, String to) {
        return searchBy(from, to);
    }


    public Airfare[] searchBy(String fromOpt, String toOpt) {
        Airfare[] result = new Airfare[0]; // тут будем хранить подошедшие запросу продукты

        for (Airfare product : findAll()) {
            if (matchesIATA(product, fromOpt, toOpt)) {
                Airfare[] tmp = new Airfare[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }

        }
        return result;
    }


    // метод определения соответствия товара product запросу search
    public boolean matchesIATA(Airfare product, String searchFrom, String searchTo) {
        if (product.getArrivalAirport() == searchTo & product.getDepartureAirport()== searchFrom) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }

}
