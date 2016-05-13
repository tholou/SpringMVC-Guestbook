$(function() {
    var config = {
        //base: 'http://localhost/swapeazy/index.php/',
        //asset: 'http://localhost/swapeazy/themes/bootlistings/',
        //someOtherPref: 4
        //

        base: 'http://justswap.azurewebsites.net/index.php/',
        asset: 'http://justswap.azurewebsites.net/themes/bootlistings/',
        someOtherPref: 4
    };
    /* ==================================================================
     *        SIGN UP
     *
     *
     *  =================================================================
     */
    $("#newUserForm").submit(function () {
        jxFactory(config, 'newUserForm', 'users/join', 'Creating your account...');
        return false;
    });

    $("#commentBox").click(function () {
        alert("Happy");
        return false;
    });
    /* ==================================================================
     *        LOGON
     *  =================================================================
     */
    $("#loginForm").submit(function () {
        jxFactoryX(config,'loader_elem_login', 'loginForm', 'users/login', 'Authenticating YOU :)');
        return false;
    });


    /* ==================================================================
     *        CHANGE PASSWORD
     *  =================================================================
     */
    $("#changePasswordForm").submit(function () {
        jxFactory(config, 'changePasswordForm', 'accounts/change_pass', 'Updating admin password :)');
        return false;
    });

    /* ==================================================================
     *        LISITINGS
     *  =================================================================
     */
    $("#newListingForm").submit(function () {
        jxFactory(config, 'newListingForm', 'listings/create', 'Uploading your Item :)');
        return false;
    });

    $("#swapForm").submit(function () {
        swal({title: 'Confirm Swap?',text: 'Are you willing to give your Item up for this Listing', type: 'info', showCancelButton: true,
                confirmButtonColor: '#3085d6', cancelButtonColor: '#d33', confirmButtonText: 'Yes, SWAP!',closeOnConfirm: false
            },
            function() {
                jxFactory(config, 'swapForm', 'requests/swap', ' :)');
            });
        return false;
    });

    $("#newRequestForm").submit(function () {
        swal({title: 'Confirm Invitation',text: 'A swap invitation will be sent to Item owner', type: 'info', showCancelButton: true,
                confirmButtonColor: '#3085d6', cancelButtonColor: '#d33', confirmButtonText: 'Yes, Invite!',closeOnConfirm: false
            },
            function() {
                jxFactory(config, 'newRequestForm', 'requests/initiate', 'Initiating a request to product owner :)');
            });
        return false;
    });

    $("#swapAcceptanceForm").submit(function () {
        swal({title: 'Confirm Swap?',text: 'Items will be swapped after this action', type: 'info', showCancelButton: true,
                confirmButtonColor: '#3085d6', cancelButtonColor: '#d33', confirmButtonText: 'Yes, Finalize!',closeOnConfirm: false
            },
            function() {
                //var requestID = this.re
                jxFactory(config, 'swapAcceptanceForm', 'requests/swap_decision', 'Initiating a request to product owner :)');
            });
        return false;
    });

    /* ==================================================================
     *        SERVICE UNAVIALABLE
     *  =================================================================
     */
    









    /* ==================================================================
     *        TERMINALS
     *  =================================================================
     */

    //Terminal Top-up
    $('.topUp').each(function () {
        $(this).on("submit", function () {
            jxFactoryX(config, this.id+'_', this.id, 'transactions/recharge/', 'Recharging Terminal...');
            return false;
        });
    });
    //Terminal Connectiviity
    $('.changeStatus').each(function () {
        $(this).on("submit", function () {
            jxFactoryX(config, this.id+'_', this.id, 'terminals/status/', 'Changing Status...');
            return false;
        });
    });


//Reset Form
    function clear_form(element) {
        $(element).find(':input').each(function () {
            switch (this.type) {
                case 'password':
                case 'select-multiple':
                case 'select-one':
                case 'text':
                case 'email':
                case 'textarea':
                    $(this).val('');
                    break;
                case 'checkbox':
                case 'radio':
                    this.checked = false;
            }
        });
    }


//Functions Cover for AJAX Interactions
    //Functions Cover for AJAX Interactions
    function jxFactory(config, datapoint, destination, staller) {
        var loader = $("#loader_elem");
        var formdata = $("#" + datapoint);
        if (loader && formdata) {
            //loader.html('<img src=' + config.asset + 'images/balls.gif />&nbsp;' + staller);
            $.post(config.base + destination, formdata.serialize(), function (response) {
                var json_response = eval('(' + response + ')');
                console.log(json_response.success);
                if (json_response.success == 200) {
                    sweetAlert('Nice',json_response.msg , 'success');
                    /*loader.slideDown('slow');
                     loader.html(
                     "<div class=\"alert alert-dismissible alert-success>" +
                     "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>" +
                     "<span>" + json_response.msg + "</span></div>");*/
                    if (json_response.url_redirect) {
                        window.location.href = json_response.url_redirect;
                    }
                    clear_form(formdata);
                }
                else {
                    sweetAlert('Oops...',json_response.msg , 'error');
                    /*loader.html(
                     "<div class=\"alert alert-dismissible alert-danger\">" +
                     "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>" +
                     "<span>" + json_response.msg + "</span></div>");*/
                }
                if (json_response.error) {
                    sweetAlert('Oops...',json_response.error , 'error');
                    /*loader.html("<div class=\"alert alert-border-left\">" +
                     json_response.error + "</div>");
                     loader.html(
                     "<div class=\"alert alert-border-left\">" +
                     "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>" +
                     "<span>" + json_response.error + "</span></div>");*/
                }

                //
            });
        }
        return false;
    }

    function jxFactoryX(config, loader, datapoint, destination, staller) {
        var loader = $("#" + loader);
        var formdata = $("#" + datapoint);
        if (loader && formdata) {
            //loader.html('<img src=' + config.asset + 'images/balls.gif />&nbsp;' + staller);
            $.post(config.base + destination, formdata.serialize(), function (response) {
                var json_response = eval('(' + response + ')');
                console.log(json_response.success);
                if (json_response.success == 200) {
                    sweetAlert('Nice',json_response.msg , 'success');
                    /*loader.slideDown('slow');
                     loader.html(
                     "<div class=\"alert alert-dismissible alert-success\">" +
                     "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>" +
                     "<span>" + json_response.msg + "</span></div>");*/
                    if (json_response.url_redirect) {
                        window.location.href = json_response.url_redirect;
                    }
                    clear_form(formdata);
                }

                if (json_response.error) {
                    sweetAlert('Oops...',json_response.error , 'error');
                    /*loader.html("<div class=\"alert alert-dismissible alert-danger\">" +
                     json_response.error + "</div>");
                     loader.html(
                     "<div class=\"alert alert-border-left\">" +
                     "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>" +
                     "<span>" + json_response.error + "</span></div>");*/
                }

                //
            });
        }
        return false;
    }

});
