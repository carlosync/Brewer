var Brewer = Brewer || {};

Brewer.EstiloCadastroRapido = (function(){
    function EstiloCadastroRapido(){
        this.modal = $('#estiloModal');
        this.botaoSalvar = this.modal.find('.js-botao-salvar');
        this.form = this.modal.find('form');
        this.url = this.form.attr('action');
        this.inputNome = $('#nomeEstilo');
        this.containerMsgErro = $('.js-mensagemErro');
    }

    EstiloCadastroRapido.prototype.iniciar = function () {
        this.form.on('submit', function(event){ event.preventDefault()});
        this.modal.on('shown.bs.modal', onModalShow.bind(this));
        this.modal.on('hide.bs.modal', onModalClose.bind(this));
        this.botaoSalvar.on('click', onBotaoSalvarClick.bind(this));
    }

    function onModalShow() {
        this.inputNome.focus();
    }

    function onModalClose(){
        this.inputNome.val('');
        this.containerMsgErro.addClass('hidden');
        this.form.find('.form-group').removeClass('has-error');
    }

    function onBotaoSalvarClick() {
        var nomeEstilo = this.inputNome.val().trim();
        $.ajax({
            url: this.url,
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({ descricao: nomeEstilo }),
            error: onErroSalvandoEstilo.bind(this),
            success: onEstiloSalvo.bind(this)
        });
    }

    function onErroSalvandoEstilo(obj){
        this.mensagemErro = obj.responseText;
        this.containerMsgErro.removeClass('hidden');
        this.containerMsgErro.html('<span>' + this.mensagemErro + '</span>');
        this.form.find('.form-group').addClass('has-error');
    }

    function onEstiloSalvo(estilo){
        var comboEstilo = $('#estilo');
        comboEstilo.append('<option value=' + estilo.codigo + '>' + estilo.descricao + '</option>');
        comboEstilo.val(estilo.codigo);
        this.modal.modal('hide');
    }

    return EstiloCadastroRapido;
}());

$(function(){
    var estiloCadastro = new Brewer.EstiloCadastroRapido();
    estiloCadastro.iniciar();
});
