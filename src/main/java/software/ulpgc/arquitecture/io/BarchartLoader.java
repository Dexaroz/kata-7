package software.ulpgc.arquitecture.io;

import software.ulpgc.arquitecture.model.Barchart;

import java.io.IOException;

public interface BarchartLoader {
    Barchart loads(int id) throws IOException;
}
