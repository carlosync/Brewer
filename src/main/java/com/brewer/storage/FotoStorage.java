package com.brewer.storage;


import org.springframework.web.multipart.MultipartFile;

public interface FotoStorage {

    public String salvarTemporariamente(MultipartFile[] files);

    public byte[] recuperarFotoTemporaria(String nome);

    public void apagarFotoTemporaria(String nome);

    public void salvar(String foto);

    public byte[] recuperarFoto(String foto);
}
