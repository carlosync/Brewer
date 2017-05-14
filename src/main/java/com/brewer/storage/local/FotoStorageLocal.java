package com.brewer.storage.local;

import com.brewer.storage.FotoStorage;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class FotoStorageLocal implements FotoStorage{

    private final static Logger LOGGER = LoggerFactory.getLogger(FotoStorageLocal.class);

    private Path local;
    private Path localTemporario;

    public FotoStorageLocal() {
        this(FileSystems.getDefault().getPath(System.getenv("HOME"), ".brewerfotos"));
    }

    public FotoStorageLocal(Path path){
        this.local = path;
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

    private String renomearArquivo(String nomeOriginal){
        String novoNome = UUID.randomUUID().toString() + "_" + nomeOriginal;
        if(LOGGER.isDebugEnabled()){
            LOGGER.debug(String.format("Nome original: %s, novo nome do arquivo: %s", nomeOriginal, novoNome));
        }
        return novoNome;
    }

    @Override
    public String salvarTemporariamente(MultipartFile[] files) {
        String novoNome = null;
        if(files != null && files.length > 0){
            MultipartFile arquivo = files[0];
            novoNome = renomearArquivo(arquivo.getOriginalFilename());
            try {
                arquivo.transferTo(
                        new File(this.localTemporario.toAbsolutePath().toString()
                                + FileSystems.getDefault().getSeparator() + novoNome));
            } catch (IOException e) {
                throw new RuntimeException("Erro salvando a foto na pasta temp..");
            }

        }
            return novoNome;
    }

    @Override
    public byte[] recuperarFotoTemporaria(String nome) {
        try {
            return Files.readAllBytes(this.localTemporario.resolve(nome));
        } catch (IOException e) {
            throw new RuntimeException("Erro lendo foto temporaria ", e);
        }
    }

    @Override
    public void apagarFotoTemporaria(String nome) {
        try {
            Files.deleteIfExists(this.localTemporario.resolve(nome));
        } catch (IOException e) {
            throw new RuntimeException("Erro ao remover foto temporaria. ", e);
        }
    }

    @Override
    public void salvar(String foto) {
        try {
            Files.move(this.localTemporario.resolve(foto), this.local.resolve(foto));
        } catch (IOException e) {
            throw new RuntimeException("Erro ao mover foto para pasta local..", e);
        }

        try {
            Thumbnails.of(this.local.resolve(foto).toString()).size(40, 68).toFiles(Rename.PREFIX_DOT_THUMBNAIL);
        } catch (IOException e) {
            throw new RuntimeException("Erro gerando thumbnail...", e);
        }
    }

    @Override
    public byte[] recuperarFoto(String nome) {
        try {
            return Files.readAllBytes(this.local.resolve(nome));
        } catch (IOException e) {
            throw new RuntimeException("Erro lendo foto da pasta ", e);
        }
    }
}
