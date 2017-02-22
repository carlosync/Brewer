package com.brewer.storage.local;

import com.brewer.storage.FotoStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class FotoStorageLocal implements FotoStorage{

    private final static Logger LOGGER = LoggerFactory.getLogger(FotoStorageLocal.class);

    private Path local;
    private Path localTemporario;

    public FotoStorageLocal() {
        this.local = FileSystems.getDefault().getPath(System.getenv("HOME"), ".brewerfotos");
        criarPastas();
    }

    private void criarPastas() {
        try {
            Files.createDirectories(this.local);
            this.localTemporario = FileSystems.getDefault().getPath(this.local.toString(), "temp");
            Files.createDirectories(this.localTemporario);

            if(LOGGER.isDebugEnabled()){
                LOGGER.debug("Pasta criadas para salvar fotos");
                LOGGER.debug("Pasta default " + this.local.toAbsolutePath());
                LOGGER.debug("Pasta temporaria " + this.localTemporario.toAbsolutePath());
            }

        } catch (IOException e) {
            throw new RuntimeException("Erro criando pasta para salvar as fotos", e);
        }
    }
}
