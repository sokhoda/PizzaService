package repository;

import domain.Cheque;
import domain.Customer;
import infrastructure.Benchmark;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemChequeRepo implements ChequeRepository {
    private final List<Cheque> chequeList = new ArrayList<>();

    @Benchmark(on = false)
    @Override
    public Cheque findById(Long id) {
        int i = 0;
        while (i < chequeList.size() && !chequeList.get(i).getId().equals(id)) {
            i++;
        }
        return i < chequeList.size() ? chequeList.get(i) : null;
    }

    @Override
    public Cheque save(Cheque newCheque) {
        chequeList.add(newCheque);
        return newCheque;
    }

    @Override
    public List<Cheque> getChequeList() {
        return chequeList;
    }
}
