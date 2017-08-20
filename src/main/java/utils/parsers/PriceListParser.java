package utils.parsers;

import dto.PizzaDto;

import java.io.InputStream;
import java.util.List;

public interface PriceListParser<T extends PizzaDto> {
    List<T> parse(InputStream file);
}
