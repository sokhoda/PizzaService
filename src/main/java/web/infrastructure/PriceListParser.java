package web.infrastructure;

import domain.Pizza;

import java.io.InputStream;
import java.util.List;

public interface PriceListParser<T extends Pizza> {
    List<T> parse(InputStream file);
}
