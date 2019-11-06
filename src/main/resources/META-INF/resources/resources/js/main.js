var util;


if (!util) {
    util = new Util();
}

function Util() {
    this.setupHashUrlsForTabs = function () {
//    What this does: when the page is loaded with a URL fragment (i.e, the #abc in example.com/index.html#abc),
//    load the tab (by "clicking" on the link) that has the same text value as the fragment.
//    Example: if you go to test.jsf#Example, the tab called "Example" will be clicked and loaded.
//    This allows individual tabs to be linked to, and puts what tab you were on in the history.

        var tabs = jQuery('ul.ui-tabs-nav li a');
        var navigateToTab = function () {
            if (window.location.hash) {
                jQuery('ul.ui-tabs-nav li a').each(function (i, el) {
                    if (jQuery(el).text() === window.location.hash.replace('#', '')) {
                        jQuery(el).click();

                    }
                })
            }
        };
        if (tabs.length) {
            navigateToTab();
        } else {
            jQuery().ready(navigateToTab);
        }
        jQuery(window).bind('hashchange', navigateToTab);
        //    This makes it so that if you click a tab, it sets the URL fragment to be the tab's title. See above.
        //    E.g. if you click on the tab called "Example", then it sets the onclick attribute of the tab's "a" tag
        //    to be "#Example"
        var setupTabFragmentLinks = function () {
            jQuery('ul.ui-tabs-nav li a').each(function (i, el) {
                el.onclick = function () {
                    window.location = '#' + jQuery(el).text()
                };
            })
        };
        if (tabs.length) {
            setupTabFragmentLinks();
        } else {
            jQuery().ready(setupTabFragmentLinks);
        }
    };
}

function onInputMaxLength(target) {
        var allInputsArray = Array.from(document.getElementsByClassName('filters__declNumber'));
        var currentIndex;
        allInputsArray.forEach(function (item, index) {
            if (target.id === item.id) {
                currentIndex = index;
            }
        });
        var maxLength = parseInt(target.attributes["maxlength"].value, 10);
        var myLength = target.value.length;
        if (myLength >= maxLength) {
            if (allInputsArray.length - 1 > currentIndex) {
                var nextTarget = allInputsArray[currentIndex + 1];
                target.blur();
                nextTarget.focus();
            }
        }
        // Move to previous field if empty (user pressed backspace)
        else if (myLength === 0) {
            if (currentIndex !== 0) {
                var nextTarget = allInputsArray[currentIndex - 1];
                target.blur();
                nextTarget.focus();
            }
        }
}
