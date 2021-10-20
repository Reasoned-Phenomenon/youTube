/*
헤더
*/

function makeHeader () {

    let conDiv = $('<div />').addClass('container');
        let rowDiv = $('<div />').addClass('row');

            let cl2Div1 = $('<div />').addClass('col-lg-2');
                let logo = $('<div />').addClass('header__logo');
                    let home = $('<a />').attr('href','homepage.html').html('<img src="../upload/JORDY.gif" height="60px" alt="">');

            $(cl2Div1).append(
                $(logo).append(home)
            );

            let cl8Div = $('<div />').addClass('col-lg-8');
                let navDiv = $('<div />').addClass('header__nav');
                    let nav = $('<nav />').addClass('header__menu mobile-menu');
                        let outUl = $('<ul />');
                            let outLi1 = $('<li />').addClass('active').html('<a href="homepage.html">Homepage</a>');
                            let outLi2 = $('<li />').html('<a href="#">Categories <span class="arrow_carrot-down"></span>');
                                let innerUl = $('<ul />').addClass('dropdown');
                                    let innerLi1= $('<li />').html('<a href="#">Anime Details</a>');
                                    let innerLi2= $('<li />').html('<a href="#">Anime Watching</a>');
                                    let innerLi3= $('<li />').html('<a href="uploadpage.html">Upload</a>');
                                    let innerLi4= $('<li />').html('<a href="yousignup.html">Sign Up</a>');
                                    let innerLi5= $('<li />').html('<a href="youlogin.html">Login</a>');
                            let outLi3 = $('<li />').html('<a href="#">Our Blog</a>');
                            let outLi4 = $('<li />').html('<a href="#">Contacts</a>');

            $(cl8Div).append(
                $(navDiv).append(
                    $(nav).append(
                        $(outUl).append(
                            $(outLi1),
                            $(outLi2).append(
                                $(innerUl).append(
                                    innerLi1,innerLi2,innerLi3,innerLi4,innerLi5
                                )
                            ),
                            $(outLi3),
                            $(outLi4)
                        )
                    )
                )
            );

            let cl2Div2 = $('<div />').addClass('col-lg-2');
                let rightDiv = $('<div />').addClass('header__right');
                    let profileSpan = $('<span />').attr('id','profile');

            $(cl2Div2).append(
                $(rightDiv).append(
                    $(profileSpan)
                )
            );

            let wrapDiv = $('<div />').attr('id','mobile-menu-wrap');

            $('.header').append(
                $(conDiv).append(
                    $(rowDiv).append(
                        $(cl2Div1),
                        $(cl8Div),
                        $(cl2Div2),
                        $(wrapDiv)
                    )
                )
            )

}

/*
footer
*/

function makeFooter () {

    
}
