$(function(){
    var modal = $('#estiloModal');
    var botaoSalvar = modal.find('.js-botao-salvar');
    var form = modal.find('form');
    form.on('submit', function(event){ event.preventDefault()});
    var url = form.attr('action');
    var inputNome = $('#nomeEstilo');
    var containerMsgErro = $('.js-mensagemErro');

    modal.on('shown.bs.modal', onModalShow);
    modal.on('hide.bs.modal', onModalClose);
    botaoSalvar.on('click', onBotaoSalvarClick);

    function onModalShow() {
        inputNome.focus();
    }

    function onModalClose(){
        inputNome.val('');
        containerMsgErro.addClass('hidden');
        form.find('.form-group').removeClass('has-error');
    }
    
    function onBotaoSalvarClick() {
        var nomeEstilo = inputNome.val().trim();
        $.ajax({
            url: url,
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({ descricao: nomeEstilo }),
            error: onErroSalvandoEstilo,
            success: onEstiloSalvo
        });
    }

    function onErroSalvandoEstilo(obj){
        var mensagemErro = obj.responseText;
        containerMsgErro.removeClass('hidden');
        containerMsgErro.html('<span>' + mensagemErro + '</span>');
        form.find('.form-group').addClass('has-error');
    }

    function onEstiloSalvo(estilo){
        var comboEstilo = $('#estilo');
        comboEstilo.append('<option value=' + estilo.codigo + '>' + estilo.descricao + '</option>');
        comboEstilo.val(estilo.codigo);
        modal.modal('hide');
    }
});
