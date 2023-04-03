export class Modal{
    constructor(_openButton, _closeButton, _modalDiv){
        openButton = _openButton;
        closeButton = _closeButton;
        modalDiv = _modalDiv;

        console.log("config");
        this.init();
    }
    init(){
        console.log("init")
        openButton.addEventListener("click", openButtonHandlerButton)

        function openButtonHandlerButton() {
            console.log("click")
            modalDiv.style.display = "block";
        }
    }
}