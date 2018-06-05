package com.rudy.notes.notes

class Notes{

    var noteID:Int?=null
    var notesName:String?=null
    var notesDes:String?=null

    constructor(noteID:Int,notesName:String,notesDes:String)
    {
        this.noteID = noteID
        this.notesDes = notesDes
        this.notesName = notesName


    }

}