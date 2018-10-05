function fieldNotSet(fieldid)
{
    return ($.trim($("#" + fieldid).val()) == '');
}
$(document).ready(function() {
    $('.nibss-nav-link').click(function() {
        $("#command").val($(this).attr("nibss-command"));
        if ($(this).attr("#nibss-action") !== null)
        {
            $("#action").val($(this).attr("nibss-action"));
        } else
        {
            $("#action").val("dashboard");
        }
        $("#mainForm").attr("target", "");
        $("#mainForm").submit();
    });

    $('.nibss-set-gbr').click(function() {
        $("#destinations").val("GBR");

    });
    $('.nibss-set-usa').click(function() {
        $("#destinations").val("USA");

    });
    $('.nibss-set-gha').click(function() {
        $("#destinations").val("GHA");

    });
    $('.nibss-set-zaf').click(function() {
        $("#destinations").val("ZAF");

    });

    $('.nibss-set-chn').click(function() {
        $("#destinations").val("CHN");

    });

    $('.nibss-set-are').click(function() {
        $("#destinations").val("ARE");

    });

    $(".nibss-detail-link").click(function() {
       
        $("#nibss-id").val($(this).attr("nibss-id"));
        $("#command").val($(this).attr("nibss-command"));
        if ($(this).attr("#nibss-action") !== null)
        {
            $("#action").val($(this).attr("nibss-action"));
        } else
        {
            $("#action").val("dashboard");
        }
        $("#mainForm").attr("target", "");
        $("#mainForm").submit();
    });
    $('[data-toggle="tooltip"]').tooltip({'placement': 'bottom', '': ''});
    $('[data-toggle="popover"]').popover();
    // for error messages
    // update the current position
    $('.sticky').css("top", $(window).scrollTop());
    // and run it again every time you scroll
    $(window).scroll(function() {
        // set dialog position to our current vertical position from the top
        $('.sticky').css("top", $(window).scrollTop());
    });

    // call the tablesorter plugin
    $(".table2").tablesorter({
        theme: 'blue',
        // initialize zebra striping and column styling of the table
        widgets: ["zebra", "columns"]
    })
            // initialize the pager plugin
            // ****************************
            .tablesorterPager({
        // **********************************
        //  Description of ALL pager options
        // **********************************

        // target the pager markup - see the HTML block below
        container: $(".pager"),
        // output string - default is '{page}/{totalPages}'; possible variables: {page}, {totalPages}, {startRow}, {endRow} and {totalRows}
        output: '{startRow} to {endRow} ({totalRows})',
        // apply disabled classname to the pager arrows when the rows at either extreme is visible - default is true
        updateArrows: true,
        // starting page of the pager (zero based index)
        page: 0,
        // Number of visible rows - default is 10
        size: 2,
        // if true, the table will remain the same height no matter how many records are displayed. The space is made up by an empty
        // table row set to a height to compensate; default is false
        fixedHeight: false,
        // remove rows from the table to speed up the sort of large tables.
        // setting this to false, only hides the non-visible rows; needed if you plan to add/remove rows with the pager enabled.
        removeRows: false,
        // css class names of pager arrows
        cssNext: '.nxt', // next page arrow
        cssPrev: '.prev', // previous page arrow
        cssFirst: '.first', // go to first page arrow
        cssLast: '.last', // go to last page arrow
        cssPageDisplay: '.pagedisplay', // location of where the "output" is displayed
        cssPageSize: '.pagesize', // page size selector - select dropdown that sets the "size" option
        cssErrorRow: 'tablesorter-errorRow', // error information row

        // class added to arrows when at the extremes (i.e. prev/first arrows are "disabled" when on the first page)
        cssDisabled: 'disabled' // Note there is no period "." in front of this class name
    });
});