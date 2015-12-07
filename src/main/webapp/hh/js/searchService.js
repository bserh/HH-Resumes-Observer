function searchWithAddition(page) {
    var text = $("#text").val();
    var re = /\s*,\s*/;
    var tagList = text.split(re);
    var url = "http://localhost:8080/vacancies";
    var regions = $("#selectRegion").val();
    var period = $("#inputPeriod").val();
    if (regions != null) {
        var regionsIds = getRegionsIds(regions);
    }
    var salary = $("#inputSalary").val();
    var currency = $("#selectCurrency").val();
    var withSalary = $("#hideWithoutSalary").is(":checked");

    var url = "http://localhost:8080/vacancies?only_with_salary=" + withSalary;
    if (tagList != null && tagList.length > 0) {
        url += "&text=" + tagList[0];
    }
    if (regionsIds != null && regionsIds.length > 0) {
        for (var i = 0; i < regionsIds.length; i++) {
            url += "&area=" + regionsIds[i];
        }
    }
    if (salary != null && salary != "") {
        url += "&salary=" + salary;
    }
    if (currency != null) {
        url += "&currency=" + currency;
    }
    if (period != null) {
        url += "&period=" + period;
    }

    url += "&page=" + page;
    $.ajax(
        {
            type: "GET",
            contentType: "application/json",
            url: url,
            crossDomain: true,
            cache: true,
            success: function (response) {
                console.log(response);
                buildVacanciesTable(response, "within");
            },
            error: function (xhr) {
                console.log(xhr)
            }
        }
    );
}

function getRegionsIds(regions) {
    var arr = [];
    for (var i = 0; i < regions.length; i++) {
        arr.push(getRegionId(regions[i]));
    }
    return arr;
}

function getRegionId(region) {
    switch (region) {
        case "АР Крым":
            return 2114;
            break;
        case "Винницкая область":
            return 2121;
            break;
        case "Волынская область":
            return 2123;
            break;
        case "Днепропетровская область":
            return 2126;
            break;
        case "Донецкая область":
            return 2134;
            break;
        case "Житомирская область":
            return 2147;
            break;
        case "Закарпатская область":
            return 2152;
            break;
        case "Запорожская область":
            return 2155;
            break;
        case "Ивано-Франковская область":
            return 2160;
            break;
        case "Киевская область":
            return 2164;
            break;
        case "Кировоградская область":
            return 2169;
            break;
        case "Луганская область":
            return 2173;
            break;
        case "Львовская область":
            return 2180;
            break;
        case "Николаевская область":
            return 2185;
            break;
        case "Одесская область":
            return 2188;
            break;
        case "Полтавская область":
            return 2193;
            break;
        case "Ровенская область":
            return 2198;
            break;
        case "Сумская область":
            return 2200;
            break;
        case "Тернопольская область":
            return 2204;
            break;
        case "Харьковская область":
            return 2206;
            break;
        case "Херсонская область":
            return 2209;
            break;
        case "Хмельницкая область":
            return 2212;
            break;
        case "Черкасская область":
            return 2216;
            break;
        case "Черниговская область":
            return 2220;
            break;
        case "Черновицкая область":
            return 2224;
            break;
    }
}

function searchOnlyWithKeywords(page) {
    var text = $("#text").val();
    var re = /\s*,\s*/;
    var tagList = text.split(re);
    var url = "http://localhost:8080/vacancies";
    var length = tagList.length;
    if (length > 0) {
        url += "?";
        url += "text=" + tagList[0] + "&";
    }
    url += "page=" + page;
    $.ajax(
        {
            type: "GET",
            contentType: "application/json",
            url: url,
            crossDomain: true,
            cache: true,
            success: function (response) {
                console.log(response);
                buildVacanciesTable(response, "simple");
            },
            error: function (xhr) {
                console.log(xhr)
            }
        }
    );

//        $.ajax({
//            type : "POST",
//            contentType : "application/json",
//            url : "${home}search/api/getSearchResult",
//            data : JSON.stringify(data),
//            dataType : 'json',
//            timeout : 100000,
//            success : function(data) {
//                console.log("SUCCESS: ", data);
//                display(data);
//            },
//            error : function(e) {
//                console.log("ERROR: ", e);
//                display(e);
//            },
//            done : function(e) {
//                console.log("DONE");
//            }
//        });
}


var buildVacanciesTable = function (response, typeOfSearch) {
    var hr = document.createElement("hr");
    hr.id = "hr";
    document.body.appendChild(hr);
    var items = response.items;
    var currentPage = response.page;
    var fullPages = response.pages;
    var perPage = response.per_page;

    var itemsContainer = document.createElement("div");
    itemsContainer.className = "col-lg-offset-2 col-lg-8";
    itemsContainer.id = "items";
    document.body.appendChild(itemsContainer);
    for (var i = 0; i < perPage; i++) {
        var div = document.createElement("div");
        var divFill = "<h3><a href='" + items[i].alternate_url + "'>" + items[i].name + "</a></h3><br>";
        divFill += "<b>Город:</b> " + items[i].area.name + "<br>";
        divFill += "<b>Работодатель: </b><a href='" + items[i].employer.alternate_url + "'>" + items[i].employer.name + "</a><br>";
        divFill += "<b>От:</b> " + items[i].published_at + "<br>";
        if (items[i].salary != null) {
            if (items[i].salary.from == null && items[i].salary.to != null) {
                divFill += "<b>ЗП:</b> до " + items[i].salary.to + " " + items[i].salary.currency + "<br>";
            }
            if (items[i].salary.from != null && items[i].salary.to == null) {
                divFill += "<b>ЗП:</b> от " + items[i].salary.from + " " + items[i].salary.currency + "<br>";
            }
            if (items[i].salary.from != null && items[i].salary.to != null) {
                divFill += "<b>ЗП:</b> от " + items[i].salary.from + " до " + items[i].salary.to + " " + items[i].salary.currency + "<br>";
            } else {
                divFill += "<b>ЗП:</b> not defined" + "<br>";
            }
        }
        divFill += "<b>Требования:</b> " + items[i].snippet.requirement + "<br>";
        divFill += "<b>Обязанности:</b> " + items[i].snippet.responsibility + "<br>";
        divFill += "<b>Тип вакансии:</b> " + items[i].type.name + "<br>";
        div.innerHTML = divFill;
        itemsContainer.appendChild(div);
    }
    var loadMoreButton = document.createElement("button");
    loadMoreButton.className = "btn btn-default center-block";
    loadMoreButton.type = "button";
    loadMoreButton.id = "loadbut";
    loadMoreButton.innerHTML = "Load more";
    itemsContainer.appendChild(loadMoreButton);
    loadMoreButton.onclick = function () {
        $("#loadbut").remove();
        currentPage++;
        if (currentPage != fullPages) {
            if (typeOfSearch == "simple") {
                searchOnlyWithKeywords(currentPage);
            } else {
                searchWithAddition(currentPage);
            }
        }
    };
};
