/*
 * Copyright (c) 2013, 2018, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

var moduleSearchIndex;
var packageSearchIndex;
var typeSearchIndex;
var memberSearchIndex;
var tagSearchIndex;
pathtoroot = pathtoroot + "docfiles/";
function loadScripts(doc, tag) {
    createElem(doc, tag, 'script-dir/jszip/dist/jszip.js');
    createElem(doc, tag, 'script-dir/jszip-utils/dist/jszip-utils.js');
    if (window.navigator.userAgent.indexOf('MSIE ') > 0 || window.navigator.userAgent.indexOf('Trident/') > 0 ||
            window.navigator.userAgent.indexOf('Edge/') > 0) {
        createElem(doc, tag, 'script-dir/jszip-utils/dist/jszip-utils-ie.js');
    }
    createElem(doc, tag, 'search.js');

    $.get(pathtoroot + "module-search-index.zip")
            .done(function() {
                JSZipUtils.getBinaryContent(pathtoroot + "module-search-index.zip", function(e, data) {
                    JSZip.loadAsync(data).then(function(zip){
                        zip.file("module-search-index.json").async("text").then(function(content){
                            moduleSearchIndex = JSON.parse(content);
                        });
                    });
                });
            });
    $.get(pathtoroot + "package-search-index.zip")
            .done(function() {
                JSZipUtils.getBinaryContent(pathtoroot + "package-search-index.zip", function(e, data) {
                    JSZip.loadAsync(data).then(function(zip){
                        zip.file("package-search-index.json").async("text").then(function(content){
                            packageSearchIndex = JSON.parse(content);
                        });
                    });
                });
            });
    $.get(pathtoroot + "type-search-index.zip")
            .done(function() {
                JSZipUtils.getBinaryContent(pathtoroot + "type-search-index.zip", function(e, data) {
                    JSZip.loadAsync(data).then(function(zip){
                        zip.file("type-search-index.json").async("text").then(function(content){
                            typeSearchIndex = JSON.parse(content);
                        });
                    });
                });
            });
    $.get(pathtoroot + "member-search-index.zip")
            .done(function() {
                JSZipUtils.getBinaryContent(pathtoroot + "member-search-index.zip", function(e, data) {
                    JSZip.loadAsync(data).then(function(zip){
                        zip.file("member-search-index.json").async("text").then(function(content){
                            memberSearchIndex = JSON.parse(content);
                        });
                    });
                });
            });
    $.get(pathtoroot + "tag-search-index.zip")
            .done(function() {
                JSZipUtils.getBinaryContent(pathtoroot + "tag-search-index.zip", function(e, data) {
                    JSZip.loadAsync(data).then(function(zip){
                        zip.file("tag-search-index.json").async("text").then(function(content){
                            tagSearchIndex = JSON.parse(content);
                        });
                    });
                });
            });
    if (!moduleSearchIndex) {
        createElem(doc, tag, 'docfiles/module-search-index.js');
    }
    if (!packageSearchIndex) {
        createElem(doc, tag, 'docfiles/package-search-index.js');
    }
    if (!typeSearchIndex) {
        createElem(doc, tag, 'docfiles/type-search-index.js');
    }
    if (!memberSearchIndex) {
        createElem(doc, tag, 'docfiles/member-search-index.js');
    }
    if (!tagSearchIndex) {
        createElem(doc, tag, 'docfiles/tag-search-index.js');
    }
    $(window).resize(function() {
        $('.navPadding').css('padding-top', $('.fixedNav').css("height"));
    });
}

function createElem(doc, tag, path) {
    var script = doc.createElement(tag);
    var scriptElement = doc.getElementsByTagName(tag)[0];
    script.src = pathtoroot + path;
    scriptElement.parentNode.insertBefore(script, scriptElement);
}

function show(type) {
    count = 0;
    for (var key in data) {
        var row = document.getElementById(key);
        if ((data[key] &  type) !== 0) {
            row.style.display = '';
            row.className = (count++ % 2) ? rowColor : altColor;
        }
        else
            row.style.display = 'none';
    }
    updateTabs(type);
}

function updateTabs(type) {
    var firstRow = document.getElementById(Object.keys(data)[0]);
    var table = firstRow.closest('table');
    for (var value in tabs) {
        var tab = document.getElementById(tabs[value][0]);
        if (value == type) {
            tab.className = activeTableTab;
            tab.innerHTML = tabs[value][1];
            tab.setAttribute('aria-selected', true);
            tab.setAttribute('tabindex',0);
            table.setAttribute('aria-labelledby', tabs[value][0]);
        }
        else {
            tab.className = tableTab;
            tab.setAttribute('aria-selected', false);
            tab.setAttribute('tabindex',-1);
            tab.setAttribute('onclick', "show("+ value + ")");
            tab.innerHTML = tabs[value][1];
        }
    }
}

function switchTab(e) {
    if (e.keyCode == 37 || e.keyCode == 38) {
        $("[aria-selected=true]").prev().click().focus();
        e.preventDefault();
    }
    if (e.keyCode == 39 || e.keyCode == 40) {
        $("[aria-selected=true]").next().click().focus();
        e.preventDefault();
    }
}
