package com.mateuscancado.catalogo_midia.exceptions;

public class MidiaNaoEncontradaException extends RuntimeException {

    public MidiaNaoEncontradaException() {
        super("Midia não encontrada no sistema");
    }

    public MidiaNaoEncontradaException(String message) {
        super(message);
    }
}
