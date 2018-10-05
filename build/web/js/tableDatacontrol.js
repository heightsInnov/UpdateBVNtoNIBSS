$(function () {
    $('#btnLaunch').click(function () {
        //Get
        var texto = $('#mytable tr:nth-child(13) td:nth-child(2)').text();
        //Set
        $('#slanditf').val(texto);

        $('#myModal').modal('show');
    });

    $('#btnSave').click(function () {
        var blaa = $('#newemail1').val();
        var tcomment = $('#tcomment').val();

        $('#mytable tr:nth-child(13) td:nth-child(4)').html(blaa, 1);
        $('#mytable tr:nth-child(13) td:nth-child(5)').html(tcomment, 1);

        $('#myModal').modal('hide');
    });
});



$(function () {
    $('#phonenumber_btnLaunch').click(function () {
        //Get
        var texto = $('#mytable tr:nth-child(12) td:nth-child(2)').text();
        //Set
        $('#oldphone1').val(texto);

        $('#myModalphone').modal('show');
    });

    $('#btnSavephone').click(function () {
        var blaa = $('#newphone1').val();
        var tcomment = $('#tcommentphone').val();

        $('#mytable tr:nth-child(12) td:nth-child(4)').html(blaa, 1);
        $('#mytable tr:nth-child(12) td:nth-child(5)').html(tcomment, 1);
        $('#HnPhone').val(blaa);
        
        
        $('#myModalphone').modal('hide');
    });
});



$(function () {
    $('#dateofbirth_btnLaunch').click(function () {
        //Get
        var texto = $('#mytable tr:nth-child(6) td:nth-child(2)').text();
        //Set
        $('#olddob').val(texto);

        $('#myModaldob').modal('show');
    });

    $('#btnSavedob').click(function () {
        var blaa = $('#newdob').val();
        var tcomment = $('#oldcommentdob').val();

        $('#mytable tr:nth-child(6) td:nth-child(4)').html(blaa, 1);
        $('#mytable tr:nth-child(6) td:nth-child(5)').html(tcomment, 1);

        $('#myModaldob').modal('hide');
    });
});

$(function () {
    $('#lastname_btnLaunch').click(function () {
        //Get
        var texto = $('#mytable tr:nth-child(5) td:nth-child(2)').text();
        //Set
        $('#oldlastname').val(texto);

        $('#myModallastname').modal('show');
    });

    $('#btnSavelast').click(function () {
        var blaa = $('#newlastname').val();
        var tcomment = $('#oldcommentlastname').val();

        $('#mytable tr:nth-child(5) td:nth-child(4)').html(blaa, 1);
        $('#mytable tr:nth-child(5) td:nth-child(5)').html(tcomment, 1);

        $('#myModallastname').modal('hide');
    });
});

$(function () {
    $('#middlename_btnLaunch').click(function () {
        //Get
        var texto = $('#mytable tr:nth-child(4) td:nth-child(2)').text();
        //Set
        $('#oldmiddlename').val(texto);

        $('#myModalmiddlename').modal('show');
    });

    $('#btnSavemiddle').click(function () {
        var blaa = $('#newmiddlename').val();
        var tcomment = $('#middlecomment').val();

        $('#mytable tr:nth-child(4) td:nth-child(4)').html(blaa, 1);
        $('#mytable tr:nth-child(4) td:nth-child(5)').html(tcomment, 1);

        $('#myModalmiddlename').modal('hide');
    });
});

$(function () {
    $('#firstname_btnLaunch').click(function () {
        //Get
        var texto = $('#mytable tr:nth-child(3) td:nth-child(2)').text();
        //Set
        $('#oldfirstname').val(texto);

        $('#myModalfirstname').modal('show');
    });

    $('#btnSavefirst').click(function () {
        var blaa = $('#newfirstname').val();
        var tcomment = $('#firstcomment').val();
        
        //$('#mytable tr:nth-child(3) td:nth-child(4)').html(blaa, 1);
        $('#mytable tr:nth-child(3) td:nth-child(5)').html(tcomment, 1);
        
        $('#nfirstname').val(blaa);
        
        $('#myModalfirstname').modal('hide');
    });
});

$(function () {
    $('#maritalStatusComment_btnLaunch').click(function () {
        //Get
        var texto = $('#mytable tr:nth-child(7) td:nth-child(2)').text();
        //Set
        $('#oldmarstat').val(texto);

        $('#myModalmarstat').modal('show');
    });

    $('#btnSavemarstat').click(function () {
        var blaa = $('#newmarstat').val();
        var tcomment = $('#oldcommentmarstat').val();

        $('#mytable tr:nth-child(7) td:nth-child(4)').html(blaa, 1);
        $('#mytable tr:nth-child(7) td:nth-child(5)').html(tcomment, 1);

        $('#myModalmarstat').modal('hide');
    });
});


$(function () {
    $('#commentGender_btnLaunch').click(function () {
        //Get
        var texto = $('#mytable tr:nth-child(8) td:nth-child(2)').text();
        //Set
        $('#oldgender').val(texto);

        $('#myModalgender').modal('show');
    });

    $('#btnSavegender').click(function () {
        var blaa = $('#newgender').val();
        var tcomment = $('#oldcommentgender').val();

        $('#mytable tr:nth-child(8) td:nth-child(4)').html(blaa, 1);
        $('#mytable tr:nth-child(8) td:nth-child(5)').html(tcomment, 1);

        $('#myModalgender').modal('hide');
    });
});


$(function () {
    $('#stateOfOriginComment_btnLaunch').click(function () {
        //Get
        var texto = $('#mytable tr:nth-child(9) td:nth-child(2)').text();
        //Set
        $('#oldstateorigin').val(texto);

        $('#myModalstateorigin').modal('show');
    });

    $('#btnSavestateorigin').click(function () {
        var blaa = $('#newstateorigin').val();
        var tcomment = $('#oldcommentstateorigin').val();

        $('#mytable tr:nth-child(9) td:nth-child(4)').html(blaa, 1);
        $('#mytable tr:nth-child(9) td:nth-child(5)').html(tcomment, 1);

        $('#myModalstateorigin').modal('hide');
    });
});



$(function () {
    $('#residentialStatusComment_btnLaunch').click(function () {
        //Get
        var texto = $('#mytable tr:nth-child(10) td:nth-child(2)').text();
        //Set
        $('#oldresidentadd').val(texto);

        $('#myModalresident').modal('show');
    });

    $('#btnSaveresidentadd').click(function () {
        var blaa = $('#newresidentadd').val();
        var tcomment = $('#oldcommentresidentadd').val();

        $('#mytable tr:nth-child(10) td:nth-child(4)').html(blaa, 1);
        $('#mytable tr:nth-child(10) td:nth-child(5)').html(tcomment, 1);

        $('#myModalresident').modal('hide');
    });
});

$(function () {
    $('#lgaComment_btnLaunch').click(function () {
        //Get
        var texto = $('#mytable tr:nth-child(11) td:nth-child(2)').text();
        //Set
        $('#oldlga').val(texto);

        $('#myModallga').modal('show');
    });

    $('#btnSavelga').click(function () {
        var blaa = $('#newlga').val();
        var tcomment = $('#oldcommentlga').val();

        $('#mytable tr:nth-child(11) td:nth-child(4)').html(blaa, 1);
        $('#mytable tr:nth-child(11) td:nth-child(5)').html(tcomment, 1);

        $('#myModallga').modal('hide');
    });
});
//Function for Title Modal
$(function () {
    $('#title_btnLaunch').click(function () {
        //Get
        var texto = $('#mytable tr:nth-child(14) td:nth-child(2)').text();
        //Set
        $('#oldtitle').val(texto);

        $('#myModaltitle').modal('show');
    });

    $('#btnSavetitle').click(function () {
        var blaa = $('#newtitle').val();
        var tcomment = $('#oldcommenttitle').val();

        $('#mytable tr:nth-child(14) td:nth-child(4)').html(blaa, 1);
        $('#mytable tr:nth-child(14) td:nth-child(5)').html(tcomment, 1);

        $('#myModaltitle').modal('hide');
    });
});