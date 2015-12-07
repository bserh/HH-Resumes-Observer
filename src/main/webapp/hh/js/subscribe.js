function subscribe() {
    var email = prompt("input email");

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
}