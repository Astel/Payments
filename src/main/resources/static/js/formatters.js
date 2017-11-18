
// replace icons with FontAwesome icons
function updatePagerIcons(table) {
    var replacement =
    {
        'ui-icon-seek-first' : 'ace-icon fa fa-angle-double-left bigger-140',
        'ui-icon-seek-prev' : 'ace-icon fa fa-angle-left bigger-140',
        'ui-icon-seek-next' : 'ace-icon fa fa-angle-right bigger-140',
        'ui-icon-seek-end' : 'ace-icon fa fa-angle-double-right bigger-140'
    };
    $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
        var icon = $(this);
        var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

        if($class in replacement) icon.attr('class', 'ui-icon '+replacement[$class]);
    })
}

// credit card number from '1313847135' to '1313 8471 3500 0000'
function digitsOf16(value) {
    var a = "" + value;
    var b = " ";
    var position = 4;
    a = [a.slice(0, position), b, a.slice(position)].join('');
    position += 5;
    a = [a.slice(0, position), b, a.slice(position)].join('');
    a += "00 0000"
    return a;
};

// account number
function formatAccountNumber(cellValue, options, rowObject) {
    return digitsOf16(cellValue);
};

// cards
function formatCardsLink(cellValue, options, rowObject) {
    return "<a href='/cards/" + cellValue + "'>cards</a>";
};

// orders
function formatOrdersLink(cellValue, options, rowObject) {
    return "<a href='/orders/" + cellValue + "'>orders</a>";
};

// account link
function formatAccountLink(cellValue, options, rowObject) {
    return "<a href='/account/" + cellValue + "'>" + digitsOf16(cellValue) + "</a>";
};


function formatUserCardsLink(cellValue, options, rowObject) {
    return "<a href='/userCards/" + cellValue + "'>cards</a>";
};

function formatUserAccountsLink(cellValue, options, rowObject) {
    return "<a href='/userAccounts/" + cellValue + "'>accounts</a>";
};
